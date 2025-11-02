const mysql = require('mysql2');

// Tạo một "pool" kết nối. 
// Pool giúp quản lý nhiều kết nối cùng lúc hiệu quả hơn.
const pool = mysql.createPool({
    host: 'no3oop-giorzangno3oop.f.aivencloud.com', // Thay bằng host của Aiven nếu dùng cloud
    port: 14566,
    user: 'avnadmin',      // Thay bằng user của bạn
    password: 'AVNS_GPxgS8Dhx3rE1cD_rBd', // Thay bằng password của bạn
    database: 'oop' // Tên database đã tạo
});

// Xuất ra pool.promise() để dùng cú pháp async/await
// Mọi Model (Product, User) sẽ import file này
module.exports = pool.promise();