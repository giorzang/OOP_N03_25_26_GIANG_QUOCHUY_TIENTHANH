const db = require('../config/database');
const bcrypt = require('bcryptjs');

class User {
    // Thuộc tính (properties)
    constructor(id, email, phone, password, name, address) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password = password; // Mật khẩu (plain hoặc hash)
        this.name = name;
        this.address = address;
    }

    // Phương thức (methods)
    /// Create user
    async save() {
        // Hash mật khẩu
        const hashedPassword = await bcrypt.hash(this.password, 12);

        return db.execute(
            'INSERT INTO users (email, phone, password, name, address) VALUES (?, ?, ?, ?, ?)',
            [
                this.email,
                this.phone,
                hashedPassword,
                this.name,
                this.address
            ]
        );
    }

    /// Read (admin)
    static async fetchAll() {
        const [rows] = await db.execute('SELECT id, email, phone, name, address FROM users');
        // Không gửi password ra ngoài!
        return rows.map(row => new User(
            row.id,
            row.email,
            row.phone,
            null, // Không gửi pass
            row.name,
            row.address
        ));
    }
    //// findById
    static async findById(id) {
        const [rows] = await db.execute('SELECT * FROM users WHERE id = ?', [id]);
        if (rows.length > 0) {
            const row = rows[0];
            return new User(
                row.id,
                row.email,
                row.phone,
                row.password, // Cần pass để login
                row.name,
                row.address
            );
        }
        return null;
    }
    //// findByEmail
    static async findByEmail(email) {
        const [rows] = await db.execute('SELECT * FROM users WHERE email = ?', [email]);
        if (rows.length > 0) {
            const row = rows[0];
            return new User(
                row.id, 
                row.email, 
                row.phone, 
                row.password,
                row.name,
                row.address
            );
        }
        return null;
    }
    //// findByPhone
    static async findByPhone(phone) {
        const [rows] = await db.execute('SELECT * FROM users WHERE phone = ?', [phone]);
        if (rows.length > 0) {
            const row = rows[0];
            return new User(
                row.id, 
                row.email, 
                row.phone, 
                row.password,
                row.name, 
                row.address
            );
        }
        return null;
    }
    //// findByEmailOrPhone
    static async findByEmailOrPhone(loginInput) {
        const [rows] = await db.execute(
            'SELECT * FROM users WHERE email = ? OR phone = ?', 
            [loginInput, loginInput]
        );
        
        if (rows.length > 0) {
            const row = rows[0];
            return new User(
                row.id,
                row.email,
                row.phone,
                row.password,
                row.name,
                row.address
            );
        }
        return null;
    }

    /// Update (user)
    async updateProfile() {
        return db.execute(
            'UPDATE users SET name = ?, phone = ?, address = ? WHERE id = ?',
            [this.name, this.phone, this.address, this.id]
        );
    }

    /// Delete (admin)
    static async deleteById(id) {
        return db.execute('DELETE FROM users WHERE id = ?', [id]);
    }

    // (Đây là 'instance method', không phải 'static')
    // So sánh mật khẩu người dùng nhập với mật khẩu đã hash
    async checkPassword(plainPassword) {
        // 'plainPassword' là pass người dùng gõ
        // 'this.password' là pass đã hash trong CSDL
        return bcrypt.compare(plainPassword, this.password);
    }
}

module.exports = User;