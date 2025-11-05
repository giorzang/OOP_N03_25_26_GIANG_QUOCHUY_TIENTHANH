const express = require('express');
const adminController = require('../controllers/adminController');
const isAdmin = require('../middleware/isAdmin');

const router = express.Router();

// === C (Create) ===
router.get('/add-product', isAdmin, adminController.getAddProduct);
router.post('/add-product', isAdmin, adminController.postAddProduct);

// === R (Read) ===
router.get('/products', isAdmin, adminController.getAdminProducts);

// === U (Update) ===
router.get('/edit-product/:productId', isAdmin, adminController.getEditProduct);
router.post('/edit-product', isAdmin, adminController.postEditProduct);

// === D (Delete) ===
router.post('/delete-product', isAdmin, adminController.postDeleteProduct);

module.exports = router;
