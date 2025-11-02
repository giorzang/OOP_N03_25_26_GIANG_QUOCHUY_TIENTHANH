const mysql = require('mysql2');

const pool = mysql.createPool({
    host: 'no3oop-giorzangno3oop.f.aivencloud.com',
    port: 14566,
    user: 'avnadmin',
    password: 'AVNS_GPxgS8Dhx3rE1cD_rBd',
    database: 'no3oop'
});

// Mọi Model (Product, User) sẽ import file này
module.exports = pool.promise();