const db = require('../config/database');

class Product {
    constructor(id, name, price, description, image_url, category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
        this.category_id = category_id
    }

    // Create product
    async save() {
        return db.execute(
            'INSERT INTO products (name, price, description, image_url, category_id) VALUES (?, ?, ?, ?, ?)',
            [this.name, this.price, this.description, this.image_url, this.category_id]
        );
    }

    // Read product
    /// Dùng JOIN để lấy tên category
    static async fetchAll() {
        const [rows] = await db.execute(
            `SELECT p.*, c.name AS category_name 
             FROM products p
             JOIN categories c ON p.category_id = c.id`
        );
        
        // Trả về đối tượng Product đầy đủ
        return rows.map(row => 
            new Product(
                row.id,
                row.name,
                row.price,
                row.description,
                row.image_url,
                row.category_id
            )
        );
    }

    static async findById(id) {
        const [rows] = await db.execute(
            `SELECT p.*, c.name AS category_name 
             FROM products p
             JOIN categories c ON p.category_id = c.id
             WHERE p.id = ?`, 
            [id]
        );
        
        if (rows.length > 0) {
            const row = rows[0];
            return new Product(
                row.id,
                row.name,
                row.price,
                row.description,
                row.image_url,
                row.category_id
            );
        }
        return null;
    }

    // Update product (Instance method)
    async update() {
        // Cập nhật sản phẩm dựa trên this.id
        return db.execute(
            `UPDATE products SET 
                name = ?, 
                price = ?, 
                description = ?, 
                image_url = ?, 
                category_id = ? 
            WHERE id = ?`,
            [
                this.name, 
                this.price, 
                this.description, 
                this.image_url, 
                this.category_id, 
                this.id
            ]
        );
    }

    // Delete product (Static method)
    static async deleteById(id) {
        return db.execute('DELETE FROM products WHERE id = ?', [id]);
    }
}

module.exports = Product;