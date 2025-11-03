const User = require('../models/user');
const bcrypt = require('bcryptjs');

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
            // (Khi làm EJS, chuyển hướng về trang hồ sơ)
            // res.redirect('/profile'); 
            
            // Tạm thời trả JSON
            res.status(200).json({ 
                message: 'Cập nhật hồ sơ thành công', 
                user: user 
            });
        });
    } catch (err) { 
        console.log(err); 
    }
};

// (Sau này, chúng ta sẽ thêm 'exports.getProfilePage' vào đây
// để hiển thị trang EJS cho người dùng cập nhật hồ sơ)