const express = require('express');
const router = express.Router();

const adminController = require('../controllers/adminController');
const isAuth = require('../middleware/isAuth');

// === C (Create) ===
router.get('/add-product', isAuth, adminController.getAddProduct);
router.post('/add-product', isAuth, adminController.postAddProduct);
router.post('/add-category', isAuth, adminController.postAddCategory);

// === R (Read) ===
router.get('/products', isAuth, adminController.getAdminProducts);
router.get('/categories', isAuth, adminController.getCategories);

// === U (Update) ===
router.get('/edit-product/:productId', isAuth, adminController.getEditProduct);
router.post('/edit-product', isAuth, adminController.postEditProduct);
router.get('/edit-category/:categoryId', isAuth, adminController.getEditCategory);
router.post('/edit-category', isAuth, adminController.postEditCategory);

// === D (Delete) ===
router.post('/delete-product', isAuth, adminController.postDeleteProduct);
router.post('/delete-category', isAuth, adminController.postDeleteCategory);

module.exports = router;