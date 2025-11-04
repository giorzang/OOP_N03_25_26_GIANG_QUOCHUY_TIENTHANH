const User = require('../models/user');
const bcrypt = require('bcryptjs');

exports.getProfilePage = (req, res, next) => {
    res.render('profile/profile', {
        pageTitle: 'Hồ sơ của bạn',
        path: '/profile',
        user: req.session.user,
        message: null
    });
};

// === (USER) Cập nhật hồ sơ (ví dụ: Tên, SĐT, Địa chỉ) ===
// Logic này được gọi bởi route: /profile/update-profile
exports.postUpdateProfile = async (req, res, next) => {
    const userId = req.session.user.id;
    const { name, phone, address } = req.body;

    try {
        const user = await User.findById(userId); 

        user.name = name;
        user.phone = phone;
        user.address = address;

        await user.updateProfile();
        
        req.session.user = user; 
        req.session.save(err => {
            if (err) {
                console.log(err);
            }
            // res.status(200).json({ 
            //     message: 'Cập nhật hồ sơ thành công', 
            //     user: user 
            // });
            res.render('profile/profile', {
                pageTitle: 'Hồ sơ của bạn',
                path: '/profile',
                user: req.session.user,
                message: 'Cập nhật hồ sơ thành công!'
            });
        });
    } catch (err) { console.log(err); }
};