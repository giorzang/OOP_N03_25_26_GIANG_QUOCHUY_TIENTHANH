const db = require('../utils/database');

class Category {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }

    // Phương thức tĩnh để lấy tất cả category
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
}

module.exports = Category;