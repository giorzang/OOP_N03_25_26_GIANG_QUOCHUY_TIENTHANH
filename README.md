## Project (Nhóm) Giang - Quốc Huy - Tiến Thành
## Thành Viên: 
**1. Vũ Trường Giang**
ID: 23010257
Chũ ký: Giang

**2. Trần Quốc Huy**
ID: 22010241
Chũ ký: Huy

**3. Nguyễn Tiến Thành**
ID: 23010841
Chũ ký: Thành

## Content [Quản lý bán hàng rau sạch online]:

## Giới Thiệu Dự Án
1. Tên dự án

Hệ thống Quản lý Bán hàng Siêu Sạch

2. Mục tiêu dự án

Dự án “Quản lý Bán hàng Siêu Sạch” được xây dựng nhằm hỗ trợ các cửa hàng kinh doanh sản phẩm sạch (như rau củ quả, thịt cá hữu cơ, sản phẩm nông nghiệp an toàn, v.v.) trong việc quản lý bán hàng, kho hàng, đơn đặt hàng và khách hàng một cách hiệu quả, chính xác và tự động hóa.

## Chi tiết lớp Model/CURD

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

##  UML DIAGRAM
**1. UML class diagram** <img width="1139" height="440" alt="image" src="https://github.com/user-attachments/assets/a34933a8-3ef3-4cb4-a032-02006ffbf89e" />


**2. UML sequence diagram**

**2.1 Create Product (Thêm sản phẩm mới)** <img width="1231" height="780" alt="image" src="https://github.com/user-attachments/assets/3a101792-4e5f-4efe-9bcd-8ca7fb89332c" />

**2.2 Read Product (Xem thông tin sản phẩm)** <img width="1271" height="661" alt="image" src="https://github.com/user-attachments/assets/15bdc55a-46ea-4b2e-8571-2c978e0696a7" />

**2.3 Update Product (Cập nhật sản phẩm)** <img width="1187" height="680" alt="image" src="https://github.com/user-attachments/assets/d446dc81-5164-493e-a707-ff9f912c0308" />

**2.4 Delete Product (Xóa sản phẩm)** <img width="1055" height="515" alt="image" src="https://github.com/user-attachments/assets/32d4a648-dc4e-46cf-80fe-b57fc1868eb8" />

