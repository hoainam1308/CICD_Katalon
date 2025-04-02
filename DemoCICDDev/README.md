# Ứng Dụng Bán Vé Xem Phim Demo

Đây là ứng dụng dùng để demo việc bán vé xem phim với Spring Boot, có chức năng hiển thị trang chủ và tìm kiếm phim theo tên.

## Tính năng

- Hiển thị danh sách phim trên trang chủ
- Tìm kiếm phim theo tên
- Hiển thị thông tin chi tiết về phim (thể loại, đạo diễn, thời lượng, mô tả)

## Cấu trúc dự án

- `model`: Chứa các entity như Movie
- `repository`: Chứa các giao diện thao tác với cơ sở dữ liệu
- `service`: Chứa business logic
- `controller`: Chứa các endpoint và xử lý yêu cầu từ client
- `config`: Chứa lớp khởi tạo dữ liệu mẫu

## Yêu cầu

- Java 17 trở lên
- Maven

## Cài đặt và chạy

1. Clone repository:
   ```
   git clone <repository-url>
   ```

2. Di chuyển vào thư mục dự án:
   ```
   cd DemoCICDDev
   ```

3. Biên dịch và chạy ứng dụng:
   ```
   mvn spring-boot:run
   ```

4. Truy cập ứng dụng web: http://localhost:8080

## Kiểm tra tính năng tìm kiếm

1. Truy cập trang chủ tại http://localhost:8080
2. Nhập tên phim vào ô tìm kiếm (ví dụ: "Ma Trận" hoặc "Người Nhện")
3. Nhấn nút "Tìm Kiếm"
4. Kết quả tìm kiếm sẽ được hiển thị bên dưới

## Cơ sở dữ liệu

Ứng dụng sử dụng H2 Database (cơ sở dữ liệu trong bộ nhớ) với dữ liệu mẫu được tự động tạo khi khởi động.
Bạn có thể truy cập H2 Console tại: http://localhost:8080/h2-console với các thông tin:
- JDBC URL: jdbc:h2:mem:moviedb
- Username: sa
- Password: (để trống)

## Kiểm thử với CI/CD

Dự án được thiết lập để kiểm thử tự động qua CI/CD. Khi có thay đổi trong mã nguồn, quy trình CI/CD sẽ:
1. Biên dịch và xây dựng ứng dụng
2. Chạy các bài kiểm thử đơn vị
3. Triển khai ứng dụng (nếu mọi thứ thành công)

Đây là một dự án demo đơn giản để kiểm tra quy trình CI/CD nên không có đầy đủ tính năng của một hệ thống bán vé xem phim thực tế. 