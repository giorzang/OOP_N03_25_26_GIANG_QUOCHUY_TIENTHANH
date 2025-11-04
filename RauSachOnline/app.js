const path = require('path');
const express = require('express');
const session = require('express-session');


const productRoutes = require('./routes/productRoutes');
const authRoutes = require('./routes/authRoutes');
const userProfileRoutes = require('./routes/userProfileRoutes');
const cartRoutes = require('./routes/cartRoutes');
const adminProductRoutes = require('./routes/adminProductRoutes');
const adminCategoryRoutes = require('./routes/adminCategoryRoutes');
const adminUserRoutes = require('./routes/adminUserRoutes');
const orderRoutes = require('./routes/orderRoutes');

const app = express();

app.set('view engine', 'ejs');
app.set('views', 'views');

app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));
app.use(
    session({
        secret: 'no3oop-secret-key-rausachonline',
        resave: false,
        saveUninitialized: false
    })
);

app.use((req, res, next) => {
    res.locals.isAuthenticated = req.session.isLoggedIn;
    res.locals.user = req.session.user; 
    next(); 
});

app.use('/admin', adminProductRoutes);
app.use('/admin', adminCategoryRoutes);
app.use('/admin', adminUserRoutes);
app.use('/profile', userProfileRoutes);
app.use('/cart', cartRoutes);
app.use('/orders', orderRoutes);

app.use(productRoutes);
app.use(authRoutes);

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server đang chạy tại http://localhost:${PORT}`);
});