const express = require('express');
const productController = require('../controllers/productController');

const router = express.Router();

// Trang chủ shop, hiển thị tất cả sản phẩm
router.get('/', productController.getProducts);
// router.get('/products/:productId', productController.getProductDetail);

module.exports = router;
