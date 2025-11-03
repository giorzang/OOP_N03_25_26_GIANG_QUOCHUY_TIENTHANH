const db = require('../config/database');

class Cart {
    constructor(id, userId) {
        this.id = id;
        this.userId = userId;
    }

    // Create cart
    static async findOrCreateByUserId(userId) {
        let [rows] = await db.execute('SELECT * FROM carts WHERE user_id = ?', [userId]);
        
        if (rows.length > 0) {
            const row = rows[0];
            return new Cart(row.id, row.user_id);
        } else {
            const [result] = await db.execute('INSERT INTO carts (user_id) VALUES (?)', [userId]);
            return new Cart(result.insertId, userId);
        }
    }

    // Read cart
    async getProducts() {
        // JOIN để lấy thông tin sản phẩm và số lượng
        const [rows] = await db.execute(
            `SELECT p.*, ci.quantity 
             FROM cart_items ci
             JOIN products p ON ci.product_id = p.id
             WHERE ci.cart_id = ?`,
            [this.id]
        );
        return rows;
    }

    // Update cart
    async addProduct(productId, quantity = 1) {
        const [rows] = await db.execute(
            'SELECT * FROM cart_items WHERE cart_id = ? AND product_id = ?',
            [this.id, productId]
        );

        if (rows.length > 0) {
            // Đã có -> Update
            const item = rows[0];
            const newQuantity = item.quantity + quantity;
            return db.execute(
                'UPDATE cart_items SET quantity = ? WHERE id = ?',
                [newQuantity, item.id]
            );
        } else {
            // Chưa có -> Create
            return db.execute(
                'INSERT INTO cart_items (cart_id, product_id, quantity) VALUES (?, ?, ?)',
                [this.id, productId, quantity]
            );
        }
    }

    async deleteProduct(productId) {
        return db.execute(
            'DELETE FROM cart_items WHERE cart_id = ? AND product_id = ?',
            [this.id, productId]
        );
    }

    // Delete cart
    async clearCart() {
        return db.execute('DELETE FROM cart_items WHERE cart_id = ?', [this.id]);
    }
}

module.exports = Cart;