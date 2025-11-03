const Product = require('../models/product');
const Category = require('../models/category');

// Create sản phẩm

/// Hiển thị trang "Thêm sản phẩm"
exports.getAddProduct = async (req, res, next) => {
    try {
        // Lấy tất cả category
        const categories = await Category.fetchAll();

        res.status(200).json({ 
            message: "Sẵn sàng thêm sản phẩm", 
            categories: categories 
        });
    } catch (err) {
        console.log(err);
    }
};

/// POST: "Thêm sản phẩm"
exports.postAddProduct = async (req, res, next) => {
    const { name, price, description, image_url, category_id } = req.body;

    const product = new Product(
        null,
        name,
        price,
        description,
        image_url,
        category_id
    );

    try {
        await product.save();
        res.redirect('/admin/products'); 
    } catch (err) { console.log(err); }
};

// Read sản phẩm
exports.getAdminProducts = async (req, res, next) => {
    try {
        const products = await Product.fetchAll();

        res.status(200).json({ 
            message: "Lấy danh sách sản phẩm (admin)", 
            products: products 
        });
    } catch (err) { console.log(err); }
};

// Update Product

/// GET: 'Sửa sản phẩm'
exports.getEditProduct = async (req, res, next) => {
    // Lấy product id từ URL (ví dụ: /admin/edit-product/1)
    const prodId = req.params.productId;
    try {
        const product = await Product.findById(prodId);
        const categories = await Category.fetchAll();
        
        if (!product) {
            return res.redirect('/');
        }

        res.status(200).json({ 
            message: "Sẵn sàng sửa sản phẩm", 
            product: product, 
            categories: categories 
        });
    } catch (err) { console.log(err); }
};

/// POST: 'Sửa sản phẩm'
exports.postEditProduct = async (req, res, next) => {
    const { productId, name, price, description, image_url, category_id } = req.body;

    try {
        const updatedProduct = new Product(
            productId,
            name,
            price,
            description,
            image_url,
            category_id
        );
        await updatedProduct.update();
        res.redirect('/admin/products');
    } catch (err) { console.log(err); }
};


// Delete sản phẩm
exports.postDeleteProduct = async (req, res, next) => {
    const { productId } = req.body;
    try {
        // Gọi phương thức static .deleteById()
        await Product.deleteById(productId);
        res.redirect('/admin/products');
    } catch (err) { console.log(err); }
};