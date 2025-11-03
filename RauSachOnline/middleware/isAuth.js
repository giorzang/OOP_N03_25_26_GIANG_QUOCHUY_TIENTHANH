module.exports = (req, res, next) => {
    // Kiểm tra xem session có cờ 'isLoggedIn' không
    if (!req.session.isLoggedIn) {
        // Nếu chưa đăng nhập, chuyển hướng về trang login
        return res.redirect('/login');
    }
    // Nếu đã đăng nhập, cho phép request đi tiếp
    next();
};