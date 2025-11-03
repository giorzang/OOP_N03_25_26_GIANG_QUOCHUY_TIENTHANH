const db = require('../config/database');

class Category {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }

    // Create category
    async save() {
        return db.execute(
            'INSERT INTO categories (name) VALUES (?)',
            [this.name]
        );
    }

    // Update category
    async update() {
        return db.execute(
            'UPDATE categories SET name = ? WHERE id = ?',
            [this.name, this.id]
        );
    }

    // Read category
    /// Phương thức tĩnh để lấy tất cả category
    static async fetchAll() {
        const [rows] = await db.execute('SELECT * FROM categories');
        return rows.map(row => new Category(row.id, row.name));
    }

    static async findById(id) {
        const [rows] = await db.execute('SELECT * FROM categories WHERE id = ?', [id]);
        if (rows.length > 0) {
            const row = rows[0];
            return new Category(row.id, row.name);
        }
        return null;
    }

    // Delete category
    static async deleteById(id) {
        // Sau khi xóa category, các sản phẩm liên quan sẽ được gán 'category_id' = NULL (do CSDL)
        return db.execute('DELETE FROM categories WHERE id = ?', [id]);
    }
}

module.exports = Category;