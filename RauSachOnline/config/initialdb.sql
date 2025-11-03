CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    address TEXT
);

CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    description TEXT,
    image_url VARCHAR(255),
    category_id BIGINT,
    
    FOREIGN KEY (category_id) 
        REFERENCES categories(id)
        ON DELETE SET NULL -- Nếu xóa category, category_id sản phẩm sẽ đặt là 'NULL'
);

CREATE TABLE carts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    
    FOREIGN KEY (user_id) 
        REFERENCES users(id)
        ON DELETE CASCADE -- Nếu xóa user, xóa luôn giỏ hàng của họ
);

CREATE TABLE cart_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cart_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    
    FOREIGN KEY (cart_id) 
        REFERENCES carts(id)
        ON DELETE CASCADE, -- Nếu xóa giỏ hàng, xóa luôn các món hàng
    FOREIGN KEY (product_id) 
        REFERENCES products(id)
        ON DELETE CASCADE -- Nếu xóa sản phẩm, xóa luôn khỏi các giỏ hàng
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    shipping_address TEXT NOT NULL,
    shipping_phone VARCHAR(20) NOT NULL,
    status VARCHAR(50) DEFAULT 'Pending', -- (Trạng thái: Pending, Confirmed, Shipped...)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT, -- Có thể NULL nếu sản phẩm bị xóa
    product_name VARCHAR(100) NOT NULL,
    product_price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE SET NULL
);