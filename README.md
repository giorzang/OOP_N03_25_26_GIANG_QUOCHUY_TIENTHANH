# Project (Nhóm) Giang - Quốc Huy - Tiến Thành


# Thành Viên: 

**1. Vũ Trường Giang**
ID: 23010257
Chũ ký: Giang


**2. Trần Quốc Huy**
ID: 22010241
Chũ ký: Huy


**3. Nguyễn Tiến Thành**
ID: 23010841
Chũ ký: Thành

# Content [Nội dung]: Project 

# Ứng dụng mua bán trực tuyến

### Classes

**1. User**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `id` | `int` | ID của người dùng |
| `name` | `String` | Tên người dùng |
| `email` | `String` | Email người dùng để đăng nhập |
| `phone` | `String` | Số điện thoại liên lạc |
| `password` | `String` | Mật khẩu đăng nhập |
| `address` | `String` | Địa chỉ giao hàng của người dùng |
| `isActive` | `boolean` | Người dùng này còn hoạt động |
| `login()` | | Đăng nhập tài khoản |
| `logout()` | | Đăng xuất tài khoản |
| `register()` | | Đăng ký tài khoản mới |
| `updateProfile()` | | Cập nhật thông tin tài khoản |

**2. Product**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `id` | `int` | ID của sản phẩm |
| `name` | `String` | Tên sản phẩm |
| `description` | `String` | Mô tả sản phẩm |
| `price` | `int` | Đơn giá sản phẩm |
| `stock` | `int` | Tồn kho của sản phẩm |
| `image` | `String` | Hình ảnh sẩn phẩm |
| `addProduct()` | | Thêm sản phản mới |
| `getProduct()` | | Lấy thông tin sản phản |
| `updateProduct()` | | Cập nhật thông tin sản phản |
| `deleteProduct()` | | Xóa thông tin sản phản **(bỏ qua)** |

**3. Category**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `id` | `int` | ID loại sản phẩm |
| `description` | `String` | Mô tả loại sản phẩm |
| `productId` | `int` | Mô tả loại sản phẩm |
| `addCategory()` | | Thêm sản phản mới |
| `getCategory()` | | Lấy thông tin sản phản |
| `updateCategory()` | | Cập nhật thông tin sản phản |
| `deleteCategory()` | | Xóa thông tin sản phản **(bỏ qua)** |

**4. Order**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `id` | `int` | ID của sản phẩm |
| `userId` | `int` | Người dùng mua hàng |
| `orderDate` | `String` | Thời gian tạo đơn hàng |
| `status` | `int` | Trạng thái đơn hàng |
| `totalAmount` | `int` | Tổng giá trị đơn hàng |
| `shippingAddress` | `String` | Địa chỉ giao hàng |
| `createOrder()` | | Thêm sản phản mới |
| `viewOrder()` | | Lấy thông tin đơn hàng |
| `updateOrder()` | | Cập nhật thông tin đơn hàng |
| `cancelOrder()` | | Hủy đơn hàng |


# Sô đồ khối yêu cầu<img width="1062" height="648" alt="image" src="https://github.com/user-attachments/assets/65a055fa-7d94-4f83-8267-a213ffee452b" />



