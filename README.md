# Project(Nhóm ) Giang - Quốc Huy - Tiến Thành


# Thành Viên: 

**1. Vũ Trường Giang**
ID: 
Chũ ký: 


**2. Trần Quốc Huy**
ID: 
Chũ ký: 


**3. Nguyễn Tiến Thành**
ID: 23010841
Chũ ký: Thành

# Ứng dụng mua bán trực tuyến

### Sơ đồ khối

### Đối tượng
- `User`
  - Thuộc tính: 
    - `id`
    - `name`
    - `email`
    - `password`
    - `phone`
  - Phương thức:
    - `addUser`
    - `updateUser`
- `Shop`
  - Thuộc tính: 
    - `id`
    - `name`
    - `userId`
  - Phương thức:
    - `addProduct()`
    - `updateProduct()`
- `Product`
  - Thuộc tính:
    - `id`
    - `name`
    - `price`
    - `stock`
    - `shopId`
  - Phương thức:
- `Cart`
  - Thuộc tính:
    - `userId`
    - `productId`
    - `picked`
  - Phương thức:
    - `pickProduct()`
    - `unpickProduct()`
    - `calculateTotal()`
- `Order`
  - Thuộc tính:
    - `id`
    - `userId`
    - `productId`
    - `status`
    - `shippingAddress`
  - Phương thức:
- `Delivery`
  - Thuộc tính:
    - `id`
    - `orderId`
    - `status`
  - Phương thức:
- `Review`
  - Thuộc tính:
    - `id`
    - `userId`
    - `productId`
    - `rating`
    - `comment`
  - Phương thức: