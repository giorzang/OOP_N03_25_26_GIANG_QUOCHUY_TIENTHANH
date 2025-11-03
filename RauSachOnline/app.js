const path = require('path');
const express = require('express');
const session = require('express-session');

// Import Routes
const authRoutes = require('./routes/authRoutes');
const adminRoutes = require('./routes/adminRoutes');

const app = express();

app.set('view engine', 'ejs');
app.set('views', 'views'); // Chỉ định thư mục views

// Cấu hình xử lý (Middleware)
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));
app.use(
    session({
        secret: 'no3oop-secret-key-rausachonline',
        resave: false,
        saveUninitialized: false
    })
);

// Middleware này sẽ chạy với MỌI request
app.use((req, res, next) => {
    // res.locals là một đối tượng mà Express sẽ tự động truyền vào TẤT CẢ các file EJS
    res.locals.isAuthenticated = req.session.isLoggedIn;
    res.locals.user = req.session.user; // Gửi cả thông tin user (nếu cần)
    next(); // next() để request đi tiếp
});

// Sử dụng Routes
app.use('/admin', adminRoutes);
app.use(authRoutes);

// START Server GOGO
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server đang chạy tại http://localhost:${PORT}`);
});