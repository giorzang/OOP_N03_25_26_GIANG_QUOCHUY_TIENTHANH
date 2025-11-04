const express = require('express');
const userController = require('../controllers/userController');
const isAuth = require('../middleware/isAuth');

const router = express.Router();

router.get('/', isAuth, userController.getProfilePage);
router.post('/update-profile', isAuth, userController.postUpdateProfile);

module.exports = router;