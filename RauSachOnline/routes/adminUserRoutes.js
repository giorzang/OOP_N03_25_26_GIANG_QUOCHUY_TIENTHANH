const express = require('express');
const adminController = require('../controllers/adminController');
const isAdmin = require('../middleware/isAdmin');

const router = express.Router();

// === R (Read) ===
router.get('/users', isAdmin, adminController.getUsers);

// === U (Update) ===
router.post('/toggle-admin', isAdmin, adminController.postToggleAdmin);

// === D (Delete) ===
router.post('/delete-user', isAdmin, adminController.deleteUser);

module.exports = router;
