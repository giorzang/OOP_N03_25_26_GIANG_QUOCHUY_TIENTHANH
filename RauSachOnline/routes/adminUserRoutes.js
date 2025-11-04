const express = require('express');
const adminController = require('../controllers/adminController');
const isAuth = require('../middleware/isAuth');

const router = express.Router();

// === R (Read) ===
router.get('/users', isAuth, adminController.getUsers);

// === D (Delete) ===
router.post('/delete-user', isAuth, adminController.deleteUser);

module.exports = router;
