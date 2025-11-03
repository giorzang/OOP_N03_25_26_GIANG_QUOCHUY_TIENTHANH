const Product = require('../models/product'); 

exports.getProducts = async (req, res, next) => {
    try {
        const products = await Product.fetchAll();
        // res.render('shop/product-list', {
        //     prods: products,
        //     pageTitle: 'Shop Rau Sạch',
        //     path: '/'
        // });

        // Tạm trả JSON để test backend
        res.status(200).json({ products: products });

    } catch (err) {
        console.log(err);
    }
};

// thêm hàm 'getProductDetail' sau