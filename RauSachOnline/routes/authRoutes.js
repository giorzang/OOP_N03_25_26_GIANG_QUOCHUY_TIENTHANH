const express = require('express');
const authController = require('../controllers/authController');

const router = express.Router();

// Khi người dùng GET/POST /register
router.get('/register', authController.getRegister);
router.post('/register', authController.postRegister);

// Khi người dùng GET/POST trang /login
router.get('/login', authController.getLogin);
router.post('/login', authController.postLogin);

// Khi người dùng POST /logout
router.post('/logout', authController.postLogout);

module.exports = router;