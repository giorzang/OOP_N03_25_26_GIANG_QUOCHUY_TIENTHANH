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

### Classes

**1. User**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `id` | `int` | ID của người dùng |
| `name` | `String` | Tên người dùng |
| `email` | `String` | Email người dùng để đăng nhập |
| `password` | `String` | Mật khẩu đăng nhập |
| `phone` | `String` | Số điện thoại liên lạc |
| `login()` | | Đăng nhập tài khoản |
| `logout()` | | Đăng xuất tài khoản |
| `update()` | | Cập nhật thông tin tài khoản |

**2. Shop**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `id` | `int` | ID của cửa hàng |
| `name` | `String` | Tên cửa hàng |
| `userId` | `int` | ID người dùng sở hữu cửa hàng |
| `description` | `String` | Mô tả cửa hàng |
| `rating` | `float` | Đánh giá cửa hàng |
| `update()` | | Cập nhật thông tin cửa hàng |
| `addProduct()` | | Thêm sản phẩm mới |

**3. Product**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `id` | `int` | ID của sản phẩm |
| `name` | `String` | Tên sản phẩm |
| `price` | `int` | Đơn giá sản phẩm |
| `stock` | `int` | Tồn kho của sản phẩm |
| `shopId` | `int` | ID cửa hàng bán sản phẩm |
| `category` | `String` | Phân loại sản phẩm |
| `description` | `String` | Mô tả sản phẩm |
| `image` | `String` | Hình ảnh sẩn phẩm |
| `update()` | | Sửa thông tin sản phản |

**3. Cart**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `userId` | `int`

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
<img width="1132" height="777" alt="image" src="https://github.com/user-attachments/assets/abf3b3af-b45b-4c37-9868-5c67d5f79373" />
