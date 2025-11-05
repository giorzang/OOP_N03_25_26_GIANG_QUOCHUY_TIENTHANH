const db = require('../config/database');
const bcrypt = require('bcryptjs');

class User {
    // Thuộc tính (properties)
    constructor(id, email, phone, password, name, address, isAdmin) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.address = address;
        this.isAdmin = isAdmin || false; // Mac dinh la false
    }

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
            row.address,
            row.isAdmin
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
                row.address,
                row.isAdmin
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
                row.address,
                row.isAdmin
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
                row.address,
                row.isAdmin
            );
        }
        return null;
    }
    
    //// findByEmailOrPhone (HÀM BỊ THIẾU/LỖI CÚ PHÁP TRƯỚC ĐÓ)
    static async findByEmailOrPhone(loginInput) {
        const [rows] = await db.execute(
            'SELECT * FROM users WHERE email = ? OR phone = ?', 
            // Dùng loginInput cho cả email và phone để tìm kiếm theo 1 trong 2
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
                row.address,
                row.isAdmin
            );
        }
        return null;
    }

    // --- CÁC HÀM BỔ SUNG KHÁC ---
    async updateProfile() {
        return db.execute(
            'UPDATE users SET name = ?, phone = ?, address = ? WHERE id = ?',
            [this.name, this.phone, this.address, this.id]
        );
    }
    
    async updatePassword(newPlainPassword) {
        const newHashedPassword = await bcrypt.hash(newPlainPassword, 12);
        return db.execute(
            'UPDATE users SET password = ? WHERE id = ?',
            [newHashedPassword, this.id]
        );
    }

    static async deleteById(id) {
        return db.execute('DELETE FROM users WHERE id = ?', [id]);
    }
    
    // Hàm Wishlist (Đã cung cấp trước đó)
    async getWishlistProductIds() {
        const [rows] = await db.execute(
            'SELECT product_id FROM wishlist WHERE user_id = ?',
            [this.id]
        );
        return rows.map(row => row.product_id.toString());
    }

    async toggleWishlist(productId) {
        const wishlistIds = await this.getWishlistProductIds();
        const productIdStr = productId.toString();
        
        if (wishlistIds.includes(productIdStr)) {
            await db.execute(
                'DELETE FROM wishlist WHERE user_id = ? AND product_id = ?',
                [this.id, productId]
            );
            return { action: 'removed' };
        } else {
            await db.execute(
                'INSERT INTO wishlist (user_id, product_id) VALUES (?, ?)',
                [this.id, productId]
            );
            return { action: 'added' };
        }
    }

    async checkPassword(plainPassword) {
        return bcrypt.compare(plainPassword, this.password);
    }
}

module.exports = User;