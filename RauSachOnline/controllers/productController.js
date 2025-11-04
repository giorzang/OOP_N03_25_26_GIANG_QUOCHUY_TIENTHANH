const Product = require('../models/product'); 

exports.getProducts = async (req, res, next) => {
    try {
        const products = await Product.fetchAll();
        // res.status(200).json({ products: products });
        res.render('shop/product-list', {
            prods: products,
            pageTitle: 'Shop Rau Sạch',
            path: '/'
        });
    } catch (err) {
        console.log(err);
    }
};

// exports.getProductDetail = async (req, res, next) => {}