const path = require('path');
const express = require('express');
const session = require('express-session');
const flash = require('connect-flash'); // <<< 1. IMPORT connect-flash

// Import Routes
/// Routes công khai
const productRoutes = require('./routes/productRoutes');
const authRoutes = require('./routes/authRoutes');
/// Routes của User
const userProfileRoutes = require('./routes/userProfileRoutes');
const cartRoutes = require('./routes/cartRoutes');
/// Routes của Admin
const adminProductRoutes = require('./routes/adminProductRoutes');
const adminCategoryRoutes = require('./routes/adminCategoryRoutes');
const adminUserRoutes = require('./routes/adminUserRoutes');
const orderRoutes = require('./routes/orderRoutes');

const app = express();

app.set('view engine', 'ejs');
app.set('views', 'views');

// Cấu hình xử lý (Middleware)
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

// Cấu hình Session
app.use(
    session({
        secret: 'no3oop-secret-key-rausachonline',
        resave: false,
        saveUninitialized: false
        // Lưu ý: Nếu dùng MySQL, bạn cần thêm session store ở đây.
    })
);

// 2. SỬ DỤNG connect-flash (PHẢI SAU session())
app.use(flash()); 

// Middleware này sẽ chạy với MỌI request
app.use((req, res, next) => {
    // res.locals là một đối tượng mà Express sẽ tự động truyền vào TẤT CẢ các file EJS
    
    // Auth & User Info
    res.locals.isAuthenticated = req.session.isLoggedIn;
    res.locals.user = req.session.user; 
    
    // Flash Messages: Đưa messages vào res.locals để EJS có thể truy cập
    // Lưu ý: req.flash() trả về một mảng, nên ta lấy phần tử đầu tiên (hoặc null nếu không có)
    res.locals.successMessage = req.flash('success'); 
    res.locals.errorMessage = req.flash('error'); 
    
    next();
});

// Sử dụng Routes
app.use('/admin', adminProductRoutes);
app.use('/admin', adminCategoryRoutes);
app.use('/admin', adminUserRoutes);
app.use('/profile', userProfileRoutes);
app.use('/cart', cartRoutes);
app.use('/orders', orderRoutes);

app.use(productRoutes);
app.use(authRoutes);

// START Server GOGO
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server đang chạy tại http://localhost:${PORT}`);
});
