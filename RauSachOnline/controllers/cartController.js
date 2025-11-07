const Cart = require('../models/cart');

exports.getCart = async (req, res, next) => {
    try {
        const cart = await Cart.findOrCreateByUserId(req.session.user.id);
        const products = await cart.getProducts();

        let total = 0;
        products.forEach(p => {
            total += p.quantity * p.price;
        });

        // res.status(200).json({ 
        //     products: products, 
        //     totalPrice: total 
        // });
        res.render('cart/cart', {
            path: '/cart',
            pageTitle: 'Giỏ hàng của bạn',
            products: products,
            totalPrice: total
        });
    } catch (err) { console.log(err); }
};

// Create
exports.postAddToCart = async (req, res, next) => {
    const { productId } = req.body; 
    try {
        const cart = await Cart.findOrCreateByUserId(req.session.user.id);
        await cart.addProduct(productId, 1); 
        req.flash('success', 'Đã thêm sản phẩm vào giỏ hàng!');
        res.redirect('/');
    } catch (err) { console.log(err); }
};

// Delete
exports.postDeleteFromCart = async (req, res, next) => {
    const { productId } = req.body;
    try {
        const cart = await Cart.findOrCreateByUserId(req.session.user.id);
        await cart.deleteProduct(productId);
        res.redirect('/cart');
    } catch (err) { console.log(err); }
};
