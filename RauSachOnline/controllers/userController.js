const User = require('../models/user');
const bcrypt = require('bcryptjs');

// --- HÀM 1: HIỂN THỊ TRANG HỒ SƠ ---
exports.getProfilePage = (req, res, next) => {
    // Lưu ý: Có thể cần gọi User.findById(req.session.user.id) để lấy dữ liệu mới nhất
    // nhưng tạm thời dùng req.session.user để tránh gọi DB quá nhiều
    res.render('profile/profile', {
        pageTitle: 'Hồ sơ của bạn',
        path: '/profile',
        user: req.session.user,
        message: req.flash('success')[0] || null, // Sử dụng req.flash
        errorMessage: req.flash('error')[0] || null // Sử dụng req.flash 
    });
};

// --- HÀM 2: XỬ LÝ CẬP NHẬT HỒ SƠ (POST) ---
exports.postUpdateProfile = async (req, res, next) => {
    const userId = req.session.user?.id;
    const { name, phone, address } = req.body;

    if (!userId) {
        req.flash('error', 'Không tìm thấy người dùng. Vui lòng đăng nhập lại.');
        return res.redirect('/login');
    }

    try {
        const user = await User.findById(userId);
        if (!user) {
            req.flash('error', 'Không tồn tại người dùng này trong hệ thống!');
            return res.redirect('/profile');
        }

        // Cập nhật thuộc tính của đối tượng User Instance
        user.name = name;
        user.phone = phone;
        user.address = address;

        await user.updateProfile();

        // Cập nhật Session (quan trọng)
        req.session.user = { 
            id: user.id,
            email: user.email, 
            name: user.name // Chỉ cập nhật các field cần thiết trong session
            // ... các field khác
        }; 

        req.session.save(err => {
            if (err) console.error('Lỗi khi lưu session:', err);
            req.flash('success', '✅ Cập nhật hồ sơ thành công!');
            res.redirect('/profile');
        });
    } catch (error) {
        console.error('Lỗi khi cập nhật hồ sơ:', error);
        req.flash('error', '❌ Đã xảy ra lỗi trong quá trình cập nhật hồ sơ!');
        res.redirect('/profile');
    }
};


// --- BỔ SUNG: HIỂN THỊ TRANG ĐỔI MẬT KHẨU ---
exports.getChangePassword = (req, res, next) => {
    res.render('profile/change-password', {
        pageTitle: 'Đổi Mật Khẩu',
        path: '/profile/change-password',
        user: req.session.user,
        errorMessage: req.flash('error')[0] || null,
        successMessage: req.flash('success')[0] || null,
    });
};

// --- BỔ SUNG: XỬ LÝ ĐỔI MẬT KHẨU (POST) ---
exports.postChangePassword = async (req, res, next) => {
    const userId = req.session.user?.id;
    const { oldPassword, newPassword, confirmPassword } = req.body;

    if (!userId) {
        req.flash('error', 'Lỗi xác thực. Vui lòng đăng nhập lại.');
        return res.redirect('/login');
    }

    if (newPassword !== confirmPassword) {
        req.flash('error', 'Mật khẩu mới và xác nhận mật khẩu không khớp.');
        return res.redirect('/profile/change-password');
    }
    
    // Thêm validation độ dài mật khẩu ở đây

    try {
        const user = await User.findById(userId);
        
        // 1. Kiểm tra Mật khẩu cũ
        const passwordIsValid = await user.checkPassword(oldPassword);
        
        if (!passwordIsValid) {
            req.flash('error', 'Mật khẩu cũ không chính xác.');
            return res.redirect('/profile/change-password');
        }
        
        // 2. Cập nhật Mật khẩu mới
        await user.updatePassword(newPassword);

        // 3. Thông báo và chuyển hướng
        req.flash('success', '✅ Đổi mật khẩu thành công!');
        res.redirect('/profile'); // Chuyển về trang hồ sơ chính
        
    } catch (error) {
        console.error('Lỗi khi đổi mật khẩu:', error);
        req.flash('error', '❌ Đã xảy ra lỗi trong quá trình đổi mật khẩu.');
        res.redirect('/profile/change-password');
    }
};
