const User = require('../models/user');
const bcrypt = require('bcryptjs');

// Hiển thị trang/form đăng ký (GET)
exports.getRegister = (req, res, next) => {
    // res.status(200).json({ 
    //     message: 'Trang đăng ký',
    //     errorMessage: null 
    // });
    res.render('auth/register', {
        path: '/register',
        pageTitle: 'Đăng Ký',
        errorMessage: null 
    });
};

// Xử lý logic khi người dùng nhấn nút "Đăng ký" (POST)
exports.postRegister = async (req, res, next) => {
    // Lấy thêm dữ liệu từ form
    const { email, phone, password, confirmPassword, name, address } = req.body;

    // Bắt lỗi & Xác thực
    if (password !== confirmPassword) {
        // return res.status(422).json({ errorMessage: 'Mật khẩu xác nhận không khớp!' });
        return res.status(422).render('auth/register', {
            path: '/register',
            pageTitle: 'Đăng Ký',
            errorMessage: 'Mật khẩu xác nhận không khớp!'
        });
    }

    try {
        // Kiểm tra user/email tồn tại
        const userByEmail = await User.findByEmail(email);
        if (userByEmail) {
            return res.status(422).json({ errorMessage: 'Email này đã được sử dụng!' });
        }
        const userByPhone = await User.findByPhone(phone);
        if (userByPhone) {
            return res.status(422).json({ errorMessage: 'Số điện thoại này đã tồn tại!' });
        }

        const newUser = new User(
            null,
            email,
            phone,
            password, // Mật khẩu plain (sẽ được hash trong hàm save())
            name,
            address
        );
        await newUser.save();

        // Đăng ký thành công -> Chuyển hướng sang trang Đăng nhập
        res.redirect('/login');

    } catch (err) {
        console.log(err);
    }
};

// Hiển thị trang/form đăng nhập
exports.getLogin = (req, res, next) => {
    // res.status(200).json({ 
    //     message: 'Trang đăng nhập', 
    //     errorMessage: null 
    // });
    res.render('auth/login', {
        path: '/login',
        pageTitle: 'Đăng Nhập',
        errorMessage: null
    });
};

// Xử lý logic khi người dùng nhấn nút "Đăng nhập" (POST)
exports.postLogin = async (req, res, next) => {
    // Lấy email/phone và password từ form
    const { emailOrPhone, password } = req.body;

    try {
        // Tìm user trong CSDL (Dùng phương thức Tĩnh)
        const user = await User.findByEmailOrPhone(emailOrPhone);

        // Bắt lỗi: User không tồn tại
        if (!user) {
            return res.status(422).json({ errorMessage: 'Email/Số điện thoại hoặc mật khẩu không đúng!' });
        }

        // User tồn tại -> So sánh mật khẩu
        // Controller không cần biết logic so sánh là gì (Tính trừu tượng)
        const isMatch = await user.checkPassword(password);

        // 5. Bắt lỗi: Sai mật khẩu
        if (!isMatch) {
            return res.status(422).json({ errorMessage: 'Email/Số điện thoại hoặc mật khẩu không đúng!' });
        }

        // ĐĂNG NHẬP THÀNH CÔNG
        // Lưu session vào CSDL (do express-session quản lý)
        req.session.isLoggedIn = true;
        req.session.user = user; // Lưu toàn bộ đối tượng user vào session
        
        // 'save' session trước khi redirect
        req.session.save((err) => {
            if (err) {
                console.log(err);
            }
            res.redirect('/'); // Chuyển về trang chủ
        });

    } catch (err) {
        console.log(err);
    }
};

// Xử lý Logout (POST)
exports.postLogout = (req, res, next) => {
    // Phương thức .destroy() của express-session sẽ xóa session
    req.session.destroy((err) => {
        if (err) {
            console.log(err);
        }
        // Sau khi hủy session, chuyển hướng về trang chủ
        res.redirect('/');
    });
};