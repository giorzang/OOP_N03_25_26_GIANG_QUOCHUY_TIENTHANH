const Product = require('../models/product');
const Category = require('../models/category');
const User = require('../models/user');

// Create sản phẩm
exports.getAddProduct = async (req, res, next) => {
    try {
        // Lấy tất cả category
        const categories = await Category.fetchAll();

        // res.status(200).json({ 
        //     message: "Sẵn sàng thêm sản phẩm", 
        //     categories: categories 
        // });
        res.render('admin/edit-product', {
            pageTitle: 'Thêm Sản phẩm',
            path: '/admin/add-product',
            editing: false, // form trong
            categories: categories
        });
    } catch (err) {
        console.log(err);
    }
};

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

        // res.status(200).json({ 
        //     message: "Lấy danh sách sản phẩm (admin)", 
        //     products: products 
        // });
        res.render('admin/products', {
            prods: products,
            pageTitle: 'Quản lý Sản phẩm',
            path: '/admin/products'
        });
    } catch (err) { console.log(err); }
};

// Update Product
exports.getEditProduct = async (req, res, next) => {
    // Lấy product id từ URL (ví dụ: /admin/edit-product/1)
    const prodId = req.params.productId;
    try {
        const product = await Product.findById(prodId);
        const categories = await Category.fetchAll();
        
        if (!product) {
            return res.redirect('/');
        }

        // res.status(200).json({ 
        //     message: "Sẵn sàng sửa sản phẩm", 
        //     product: product, 
        //     categories: categories 
        // });
        res.render('admin/edit-product', {
            pageTitle: 'Sửa Sản phẩm',
            path: '/admin/edit-product',
            editing: true, // form data cu
            product: product,
            categories: categories
        });
    } catch (err) { console.log(err); }
};

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

// Create category
exports.postAddCategory = async (req, res, next) => {
    const { name } = req.body;
    const category = new Category(null, name);
    try {
        await category.save();
        res.redirect('/admin/categories');
    } catch (err) { console.log(err); }
};

// Read category
exports.getCategories = async (req, res, next) => {
    try {
        const categories = await Category.fetchAll();
        // res.status(200).json({ categories: categories }); // Tạm trả JSON
        res.render('admin/categories', {
            pageTitle: 'Quản lý Phân loại',
            path: '/admin/categories',
            categories: categories,
            editing: false // Không ở chế độ Sửa
        });
    } catch (err) { console.log(err); }
};

// Update category
exports.getEditCategory = async (req, res, next) => {
    const catId = req.params.categoryId;
    try {
        const category = await Category.findById(catId);
        const categories = await Category.fetchAll();
        
        if (!category) {
            return res.redirect('/admin/categories');
        }

        // res.status(200).json({ category: category }); // Tạm trả JSON
        res.render('admin/categories', {
            pageTitle: 'Sửa Phân loại',
            path: '/admin/categories',
            categories: categories,
            editing: true, // Bật chế độ Sửa
            category: category // Gửi data của category cần sửa
        });
    } catch (err) { console.log(err); }
};

exports.postEditCategory = async (req, res, next) => {
    const { categoryId, name } = req.body;
    const category = new Category(categoryId, name);
    try {
        await category.update();
        res.redirect('/admin/categories');
    } catch (err) { console.log(err); }
};

// Delete category
exports.postDeleteCategory = async (req, res, next) => {
    const { categoryId } = req.body;
    try {
        await Category.deleteById(categoryId);
        res.redirect('/admin/categories');
    } catch (err) { console.log(err); }
};

// Create user trong auth/register
// Read user
exports.getUsers = async (req, res, next) => {
    try {
        const users = await User.fetchAll();
        // res.status(200).json({ users: users });
        res.render('admin/users', {
            pageTitle: 'Quản lý User',
            path: '/admin/users',
            users: users
        });
    } catch (err) { console.log(err); }
};

// Delete user
exports.deleteUser = async (req, res, next) => {
    const { userId } = req.body;
    try {
        await User.deleteById(userId);
        res.redirect('/admin/users'); 
    } catch (err) { console.log(err); }
};
