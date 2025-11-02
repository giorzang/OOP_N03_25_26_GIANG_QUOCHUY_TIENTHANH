const Product = require('../models/product');
const Category = require('../models/category');

// Hiển thị trang "Thêm sản phẩm"
exports.getAddProductPage = async (req, res, next) => {
    try {
        // Lấy tất cả category
        const categories = await Category.fetchAll();

        // Truyền categories ra view
        res.render('admin/edit-product', {
            pageTitle: 'Thêm sản phẩm',
            categories: categories // Truyền danh sách category
        });
    } catch (err) {
        console.log(err);
    }
};

// Khi Admin nhấn nút "Lưu"
exports.postAddProduct = async (req, res, next) => {
    // Lấy dữ liệu từ Request
    const name = req.body.name;
    const price = req.body.price;
    const description = req.body.description;
    const image_url = req.body.image_url;
    const category_id = req.body.category_id; // Lấy ID từ dropdown
    
    // Tạo đối tượng
    const product = new Product(null, name, price, description, image_url, category_id);
    
    // Lưu vào DB
    await product.save();
    res.redirect('/');
};