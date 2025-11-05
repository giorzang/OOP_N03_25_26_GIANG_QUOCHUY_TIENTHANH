## Project (Nhóm) Giang - Quốc Huy - Tiến Thành
## Thành Viên Nóm: 
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

## Chức Năng Chính
Dăng ký, đăng nhập tài khoản người dung

Dặt hàng

Hiển thị danh sach hàng đã đặt (Khách hàng), hiển thị danh sách hàng chung (Admin)

thêm sửa xóa thông tin


##  UML Dự Án
**1. UML class diagram** <img width="975" height="1273" alt="image" src="https://github.com/user-attachments/assets/8ecaae02-a1d7-4bf9-990f-3909c9bc8841" />


**2. UML sequence diagram**

2.1. CRUD (Create): Thêm sản phẩm mới (Admin) <img width="975" height="497" alt="image" src="https://github.com/user-attachments/assets/9e32b5ca-9665-4ff6-8325-23b5477119fe" />

 
2.2. CRUD (Read): Xem danh sách người dùng (Admin) <img width="975" height="510" alt="image" src="https://github.com/user-attachments/assets/4e8344c2-ae09-44ec-8e7a-b085879c9885" />

 

2.3. CRUD (Update): Cập nhật hồ sơ cá nhân (User) <img width="975" height="602" alt="image" src="https://github.com/user-attachments/assets/2da2a565-1afc-49a4-914a-8320ef2d3163" />

 
2.4. CRUD (Delete): Xóa một danh mục (Admin) <img width="975" height="465" alt="image" src="https://github.com/user-attachments/assets/cd9f76ed-f614-4a09-8d43-4fab067d63d0" />

 
2.5. Sơ đồ chức năng lõi: Đặt hàng (Place Order) <img width="975" height="703" alt="image" src="https://github.com/user-attachments/assets/178bf47d-b4ae-4d8e-91db-5973244a866f" />

## Giao Diện Ứng Dụng
**1. Giao diện Đăng ký / Đăng nhập:** <img width="975" height="471" alt="image" src="https://github.com/user-attachments/assets/253f234c-bf20-4c44-a2fe-abc424e14227" /> <img width="975" height="477" alt="image" src="https://github.com/user-attachments/assets/bd820911-b803-43a7-ac30-4d05c06b9968" />


**2. Giao diện trang chủ (Giao diện đầu tiên):** <img width="975" height="476" alt="image" src="https://github.com/user-attachments/assets/319b9e2c-a111-4e6c-9bce-1bcaeb0542f5" />


**3. Giao diện giỏ hàng:**  <img width="975" height="471" alt="image" src="https://github.com/user-attachments/assets/2bbf306e-2780-40a8-8ca3-d47aa441d942" />


**4.  Giao diện quản lý sản phẩm và thêm sản phẩm:**  <img width="975" height="477" alt="image" src="https://github.com/user-attachments/assets/4ddecc20-d18d-4c5b-8e36-fb0599e65e2d" />     <img width="975" height="470" alt="image" src="https://github.com/user-attachments/assets/c5e10cf2-267f-4f79-b7bd-025bd369b1a6" />


**5. Giao diện đơn hàng đã mua:**  <img width="975" height="467" alt="image" src="https://github.com/user-attachments/assets/4c9ee8c8-e39b-4716-aad1-9d8584d5d040" />


## Ưu Diểm Và Nhược Điểm Ứng Dụng
**1. Ưu điểm**

 •	Dự án đã hoàn thành các chức năng cơ bản của một website thương mại điện tử: quản lý sản phẩm, quản lý người dùng (xác thực, phân quyền), và luồng đặt hàng.
 
 •	Áp dụng thành công mô hình MVC (dù không tường minh) với việc tách biệt logic (Routes/Controllers), dữ liệu (Models - tương tác MySQL) và giao diện (Views - EJS).
 
 •	Sử dụng express-session để quản lý phiên đăng nhập hiệu quả và bcryptjs để đảm bảo an toàn cơ bản cho mật khẩu người dùng

**2. Nhược điẻm**

Nhược điểm
•	Giao diện người dùng vẫn còn ở mức cơ bản, chưa có tính tương tác cao (chủ yếu render phía server).

•	Chức năng giỏ hàng và có thể bị mất nếu lưu ở session.

•	Chưa xử lý các trường hợp phức tạp như: quản lý khuyến mãi, đánh giá sản phẩm, hủy đơn hàng (tự động hoàn stock).

•	Bảo mật cần được tăng cường thêm (ví dụ: chống CSRF, XSS, SQL Injection).

•	Chưa tích hợp cổng thanh toán trực tuyến.


## Kết luận Và Phát Triển Tương Lai

•	Tích hợp cổng thanh toán: Kết nối với các API thanh toán như VNPAY, MoMo.

•	Cải thiện Frontend: Sử dụng một framework JavaScript (như React, Angular) để xây dựng Giao diện người dùng (SPA) có tính tương tác cao hơn, và Node.js chỉ đóng vai trò API.

•	Nâng cao chức năng: Thêm các module: đánh giá sản phẩm, quản lý khuyến mãi, tìm kiếm và lọc sản phẩm nâng cao.

•	Tối ưu hiệu suất: Tối ưu hóa truy vấn CSDL, sử dụng cache.

•	Phát triển ứng dụng di động: Xây dựng app mobile (React Native, Flutter) kết nối với API của hệ thống.




 




