const express = require('express');
const userController = require('../controllers/userController');
const isAuth = require('../middleware/isAuth');

const router = express.Router();

router.post('/update-profile', isAuth, userController.postUpdateProfile);
// (Sau này thêm route xem trang hồ sơ)
// router.get('/', isAuth, userController.getProfilePage);

module.exports = router;