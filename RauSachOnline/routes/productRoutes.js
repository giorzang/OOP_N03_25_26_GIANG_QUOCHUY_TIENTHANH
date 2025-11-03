const express = require('express');
const productController = require('../controllers/productController');

const router = express.Router();

// Trang chủ shop, hiển thị tất cả sản phẩm
router.get('/', productController.getProducts);
// (Sau này thêm route xem chi tiết sản phẩm)
// router.get('/products/:productId', productController.getProductDetail);

module.exports = router;