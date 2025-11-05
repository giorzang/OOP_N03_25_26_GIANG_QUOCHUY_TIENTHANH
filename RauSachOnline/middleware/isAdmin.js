module.exports = (req, res, next) => {
    if (!req.session.isLoggedIn) {
        return res.redirect('/login');
    }
    // (user.isAdmin là 1 (true) hoặc 0 (false))
    if (!req.session.user.isAdmin) {
        return res.redirect('/');
    }
    next();
};