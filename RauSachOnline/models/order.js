const db = require('../config/database');
const Cart = require('./cart'); // Cần để xóa cart

class Order {
    constructor(id, userId, totalPrice, shippingAddress, shippingPhone, status) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.shippingPhone = shippingPhone;
        this.status = status;
        this.items = []; // Sẽ chứa các order_items
    }

    // === PHƯƠNG THỨC QUAN TRỌNG NHẤT (YÊU CẦU 5) ===
    // (Static method vì nó tạo ra một Order mới)
    static async createOrder(user, cart) {
        
        let connection; // Biến giữ kết nối Transaction
        try {
            // Lấy sản phẩm và tổng tiền từ giỏ hàng
            const products = await cart.getProducts();
            let total = 0;
            products.forEach(p => {
                total += p.quantity * p.price;
            });

            // Lấy kết nối từ Pool (để dùng Transaction)
            connection = await db.getConnection();
            
            // BẮT ĐẦU TRANSACTION
            await connection.beginTransaction();

            // (Bước A) Tạo đơn hàng (Bảng 'orders')
            const [orderResult] = await connection.execute(
                'INSERT INTO orders (user_id, total_price, shipping_address, shipping_phone, status) VALUES (?, ?, ?, ?, ?)',
                [user.id, total, user.address, user.phone, 'Pending']
            );
            const newOrderId = orderResult.insertId;

            // (Bước B) Chuyển sản phẩm vào chi tiết đơn hàng (Bảng 'order_items')
            // Tạo mảng các [dữ liệu]
            const orderItemsData = products.map(p => [
                newOrderId,
                p.id,
                p.name,
                p.price,
                p.quantity
            ]);

            // Chạy 1 câu query duy nhất để insert nhiều dòng
            await connection.query(
                'INSERT INTO order_items (order_id, product_id, product_name, product_price, quantity) VALUES ?',
                [orderItemsData] // Bọc trong 1 mảng
            );

            // (Bước C) Xóa rỗng giỏ hàng
            // Dùng connection của transaction
            await connection.execute(
                'DELETE FROM cart_items WHERE cart_id = ?', 
                [cart.id]
            );

            // (Bước D) COMMIT TRANSACTION
            // Nếu 3 bước A, B, C thành công, lưu tất cả
            await connection.commit();

            return { success: true, orderId: newOrderId };

        } catch (err) {
            // (Bước E) ROLLBACK TRANSACTION
            // Nếu có bất kỳ lỗi nào, hủy tất cả
            if (connection) await connection.rollback();
            
            console.log('Transaction Rolled Back:', err);
            throw err;
        } finally {
            // Luôn luôn trả kết nối về Pool
            if (connection) connection.release();
        }
    }
    
    // === READ: Lấy tất cả đơn hàng của 1 user ===
    static async findByUserId(userId) {
        const [orders] = await db.execute(
            'SELECT * FROM orders WHERE user_id = ? ORDER BY created_at DESC',
            [userId]
        );

        // Với mỗi đơn hàng, lấy các item
        for (const order of orders) {
            const [items] = await db.execute(
                'SELECT * FROM order_items WHERE order_id = ?',
                [order.id]
            );
            // Gán mảng items vào đơn hàng
            order.items = items;
        }

        return orders;
    }
}

module.exports = Order;