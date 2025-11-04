const express = require('express');
const adminController = require('../controllers/adminController');
const isAuth = require('../middleware/isAuth');

const router = express.Router();

// === C (Create) ===
router.post('/add-category', isAuth, adminController.postAddCategory);

// === R (Read) ===
router.get('/categories', isAuth, adminController.getCategories);

// === U (Update) ===
router.get('/edit-category/:categoryId', isAuth, adminController.getEditCategory);
router.post('/edit-category', isAuth, adminController.postEditCategory);

// === D (Delete) ===
router.post('/delete-category', isAuth, adminController.postDeleteCategory);

module.exports = router;
