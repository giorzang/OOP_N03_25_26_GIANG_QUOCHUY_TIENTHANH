const Product = require('../models/product');

exports.getProducts = async (req, res, next) => {
  try {
    const products = await Product.fetchAll();
    
    res.render('shop/product-list', {
      prods: products,
      pageTitle: 'Shop Rau Sạch',
      path: '/',
      editing: false 
    });
  } catch (error) {
    console.error('Lỗi khi lấy danh sách sản phẩm:', error);
    next(error); 
  }
};
