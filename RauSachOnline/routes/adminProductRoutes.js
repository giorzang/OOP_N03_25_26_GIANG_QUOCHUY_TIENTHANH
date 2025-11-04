const express = require('express');
const adminController = require('../controllers/adminController');
const isAuth = require('../middleware/isAuth');

const router = express.Router();

// === C (Create) ===
router.get('/add-product', isAuth, adminController.getAddProduct);
router.post('/add-product', isAuth, adminController.postAddProduct);

// === R (Read) ===
router.get('/products', isAuth, adminController.getAdminProducts);

// === U (Update) ===
router.get('/edit-product/:productId', isAuth, adminController.getEditProduct);
router.post('/edit-product', isAuth, adminController.postEditProduct);

// === D (Delete) ===
router.post('/delete-product', isAuth, adminController.postDeleteProduct);

module.exports = router;
