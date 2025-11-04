const express = require('express');
const orderController = require('../controllers/orderController');
const isAuth = require('../middleware/isAuth');

const router = express.Router();

// POST /orders (Tạo đơn hàng mới)
router.post('/', isAuth, orderController.postCreateOrder);
// GET /orders (Xem lịch sử đơn hàng)
router.get('/', isAuth, orderController.getOrders);

module.exports = router;
