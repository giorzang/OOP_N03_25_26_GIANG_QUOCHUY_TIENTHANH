const express = require('express');
const adminController = require('../controllers/adminController');
const isAdmin = require('../middleware/isAdmin')

const router = express.Router();

// === C (Create) ===
router.post('/add-category', isAdmin, adminController.postAddCategory);

// === R (Read) ===
router.get('/categories', isAdmin, adminController.getCategories);

// === U (Update) ===
router.get('/edit-category/:categoryId', isAdmin, adminController.getEditCategory);
router.post('/edit-category', isAdmin, adminController.postEditCategory);

// === D (Delete) ===
router.post('/delete-category', isAdmin, adminController.postDeleteCategory);

module.exports = router;
