const db = require('../utils/database');
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
    /// save()
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
    ///findByEmail
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
    /// findByPhone
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
    /// findByEmailOrPhone
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

    // (Đây là 'instance method', không phải 'static')
    // So sánh mật khẩu người dùng nhập với mật khẩu đã hash
    async checkPassword(plainPassword) {
        // Dùng bcrypt để so sánh
        // 'plainPassword' là pass người dùng gõ
        // 'this.password' là pass đã hash trong CSDL
        return bcrypt.compare(plainPassword, this.password);
    }
}

module.exports = User;