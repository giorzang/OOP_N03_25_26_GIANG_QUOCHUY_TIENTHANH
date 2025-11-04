const db = require('../config/database'); // Điều chỉnh đường dẫn đến file database của bạn

class Product {
    constructor(id, name, price, description, image_url, category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
        this.category_id = category_id;
    }


    /**
     * @returns {Promise<number>} Tổng số sản phẩm.
     */
    static async countAll() {
        try {
            // Sử dụng truy vấn SQL COUNT
            const [rows] = await db.execute('SELECT COUNT(*) AS total FROM products');
            return rows[0].total;
        } catch (error) {
            console.error('Lỗi khi đếm tổng sản phẩm:', error);
            throw error;
        }
    }

    /**
     * @param {number} limit - Số lượng sản phẩm tối đa cho mỗi trang.
     * @param {number} offset - Vị trí bắt đầu lấy dữ liệu.
     * @returns {Promise<Array<Product>>} Danh sách sản phẩm của trang đó.
     */
    static async fetchAllPaged(limit, offset) {
        try {
            const query = `
                SELECT 
                    p.*, c.name AS category_name
                FROM 
                    products p
                JOIN 
                    categories c ON p.category_id = c.id
                ORDER BY p.id DESC
                LIMIT ? OFFSET ?
            `;
            const [rows] = await db.execute(query, [limit, offset]);
            
            return rows; 
            
        } catch (error) {
            console.error('Lỗi khi lấy sản phẩm theo trang:', error);
            throw error;
        }
    }

    /**
     */
    static async fetchAll() {
         try {
            const [rows] = await db.execute(`
                SELECT p.*, c.name AS category_name
                FROM products p
                JOIN categories c ON p.category_id = c.id
                ORDER BY p.id DESC
            `);
            return rows; 
        } catch (error) {
            console.error('Lỗi khi lấy tất cả sản phẩm:', error);
            throw error;
        }
    }
}

module.exports = Product;