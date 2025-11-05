const express = require('express');
const router = express.Router();
const adminController = require('../controllers/adminController');
const isAdmin = require('../middleware/isAdmin');

router.get('/orders', isAdmin, adminController.getAdminOrders);
router.post('/update-order-status', isAdmin, adminController.postUpdateOrderStatus);

module.exports = router;