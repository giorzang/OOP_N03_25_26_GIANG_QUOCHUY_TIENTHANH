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

# Content [Quản lý bán hàng rau sạch online]: Project 

### I. CLASS

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
| `categoryId` | `int` | ID loại sản phẩm |
| `addProduct()` | | Thêm sản phản mới |
| `getProduct()` | | Lấy thông tin sản phản |
| `updateProduct()` | | Cập nhật thông tin sản phản |
| `deleteProduct()` | | Xóa thông tin sản phản **(bỏ qua)** |

**3. Category**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `id` | `int` | ID loại sản phẩm |
| `description` | `String` | Mô tả loại sản phẩm |
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

**5. OrderDetail**
| **Attribute/Method** | **Data Type** | **Description** |
|----------------------|---------------|-----------------|
| `orderId` | `int` | ID đơn hàng |
| `productId` | `int` | ID sản  |
| `quantity` | `int` | Số lượng sản phẩm |
| `price` | `int` | Giá của sản phẩm tại thời điểm mua hàng |
| `totalAmount` | `int` | Tổng giá trị đơn hàng |

II. CÔNG NGHỆ ĐÃ SỬ DỤNG:
Backend: Framework chính để phát triển ứng dụng web (theo kiến trúc MVC)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) 
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
Database: CSDL quan hệ để lưu trữ đơn hàng, sản phẩm, khách hàng...
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
Build Tool: Quản lý thư viện và biên dịch dự án
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
### III. SƠ ĐỒ CẤU TRÚCTRÚC
**1. Sơ đồ class diagram**
<img width="1087" height="542" alt="image" src="https://github.com/user-attachments/assets/c014ddca-c758-4523-a605-1897b66a1fc5" />
**1. Sơ đồ sequence diagram**




