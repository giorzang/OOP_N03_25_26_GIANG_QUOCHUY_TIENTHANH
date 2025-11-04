const User = require('../models/user');
const bcrypt = require('bcryptjs');

exports.getProfilePage = (req, res, next) => {
  res.render('profile/profile', {
    pageTitle: 'Hồ sơ của bạn',
    path: '/profile',
    user: req.session.user,
    message: null,
    errorMessage: null 
  });
};

exports.postUpdateProfile = async (req, res, next) => {
  const userId = req.session.user?.id;
  const { name, phone, address } = req.body;

  if (!userId) {
    return res.render('profile/profile', {
      pageTitle: 'Hồ sơ của bạn',
      path: '/profile',
      user: null,
      message: null,
      errorMessage: 'Không tìm thấy người dùng. Vui lòng đăng nhập lại.'
    });
  }

  try {
    const user = await User.findById(userId);
    if (!user) {
      return res.render('profile/profile', {
        pageTitle: 'Hồ sơ của bạn',
        path: '/profile',
        user: req.session.user,
        message: null,
        errorMessage: 'Không tồn tại người dùng này trong hệ thống!'
      });
    }

    user.name = name;
    user.phone = phone;
    user.address = address;

    await user.updateProfile();

    req.session.user = user;
    req.session.save(err => {
      if (err) console.error('Lỗi khi lưu session:', err);

      res.render('profile/profile', {
        pageTitle: 'Hồ sơ của bạn',
        path: '/profile',
        user,
        message: '✅ Cập nhật hồ sơ thành công!',
        errorMessage: null
      });
    });
  } catch (error) {
    console.error('Lỗi khi cập nhật hồ sơ:', error);

    res.render('profile/profile', {
      pageTitle: 'Hồ sơ của bạn',
      path: '/profile',
      user: req.session.user,
      message: null,
      errorMessage: '❌ Đã xảy ra lỗi trong quá trình cập nhật hồ sơ!'
    });
  }
};
