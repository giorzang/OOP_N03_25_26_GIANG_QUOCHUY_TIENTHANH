const express = require('express');
const cartController = require('../controllers/cartController');
const isAuth = require('../middleware/isAuth');

const router = express.Router();

// Xem giỏ hàng
router.get('/', isAuth, cartController.getCart);
// Thêm sản phẩm
router.post('/add-to-cart', isAuth, cartController.postAddToCart);
// Xóa sản phẩm
router.post('/delete-from-cart', isAuth, cartController.postDeleteFromCart);

module.exports = router;