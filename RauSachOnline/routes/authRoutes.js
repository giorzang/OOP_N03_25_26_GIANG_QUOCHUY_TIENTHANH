const express = require('express');
const authController = require('../controllers/authController');
const isGuest = require('../middleware/isGuest');
const isAuth = require('../middleware/isAuth');

const router = express.Router();

// Khi người dùng GET/POST /register
router.get('/register', isGuest, authController.getRegister);
router.post('/register', isGuest, authController.postRegister);

// Khi người dùng GET/POST trang /login
router.get('/login', isGuest, authController.getLogin);
router.post('/login', isGuest, authController.postLogin);

// Khi người dùng POST /logout
router.post('/logout', isAuth, authController.postLogout);

module.exports = router;
