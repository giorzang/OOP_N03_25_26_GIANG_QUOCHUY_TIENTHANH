const Order = require('../models/order');
const Cart = require('../models/cart');

// Tạo đơn hàng
// (Đây là logic khi nhấn nút "Thanh toán")
exports.postCreateOrder = async (req, res, next) => {
    try {
        const user = req.session.user;
        // Lấy Giỏ hàng (Cart)
        const cart = await Cart.findOrCreateByUserId(user.id);
        // Model sẽ tự xử lý toàn bộ Transaction
        const result = await Order.createOrder(user, cart);

        if (result.success) {
            // Đặt hàng thành công, chuyển hướng
            res.redirect('/orders'); 
        } else {
            // (Xử lý nếu có lỗi)
            res.redirect('/cart');
        }

    } catch (err) {
        console.log(err);
        res.redirect('/cart');
    }
};

// Xem lịch sử đơn hàng
exports.getOrders = async (req, res, next) => {
    // res.status(200).json({ 
    //     message: 'Trang lịch sử đơn hàng của bạn'
    // });
    try {
        const orders = await Order.findByUserId(req.session.user.id);
        res.render('shop/orders', {
            path: '/orders',
            pageTitle: 'Đơn hàng của bạn',
            orders: orders
        });
    } catch (err) {
        console.log(err);
    }
};
