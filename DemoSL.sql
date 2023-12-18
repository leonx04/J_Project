
CREATE TABLE PhongBan (
    MaPhong INT PRIMARY KEY,
    TenPhong NVARCHAR(50)
);
GO
CREATE TABLE NhanVien (
    MaNV INT PRIMARY KEY,
    HoTen NVARCHAR(100),
    NgaySinh DATE,
	Luong INT,
    MaPhong INT,
    FOREIGN KEY (MaPhong) REFERENCES PhongBan(MaPhong)
);
GO

INSERT INTO PhongBan (MaPhong, TenPhong) VALUES
(1, N'Phòng Kế Toán'),
(2, N'Phòng Nhân Sự'),
(3, N'Phòng Kỹ Thuật');

GO
INSERT INTO NhanVien (MaNV, HoTen, NgaySinh,Luong ,MaPhong) VALUES
(1, N'Nguyen Van A', '1990-01-15',10000000, 1),
(2, N'Tran Thi B', '1985-05-20',2000000, 2),
(3, N'Le Van C', '1995-08-10',3000000, 3),
(4, N'Pham Thi D', '1992-03-25',40000000, 1),
(5, N'Nguyen Anh V', '1992-03-25',50000000, 1),
(6, N'Tran Trung Q', '1992-03-25',60000000, 1),
(7, N'Nguyen Huu  D', '1992-03-25',40000000, 1);

--select * from NhanVien LIMIT 2;

-- Lấy tất cả dữ liệu từ bảng PhongBan
SELECT * FROM PhongBan;
GO
-- Lấy tất cả dữ liệu từ bảng NhanVien
SELECT * FROM NhanVien;
GO
-- Lấy tên phòng và tên nhân viên từ cả hai bảng
SELECT PhongBan.TenPhong, NhanVien.HoTen
FROM PhongBan
INNER JOIN NhanVien ON PhongBan.MaPhong = NhanVien.MaPhong;
GO

-- Lấy danh sách nhân viên có ngày sinh trong khoảng từ '1990-01-01' đến '1995-12-31'
SELECT * FROM NhanVien
WHERE NgaySinh BETWEEN '1990-01-01' AND '1995-12-31';
GO

-- Đếm số lượng nhân viên trong mỗi phòng
SELECT PhongBan.TenPhong, COUNT(NhanVien.MaNV) AS SoLuongNhanVien
FROM PhongBan
LEFT JOIN NhanVien ON PhongBan.MaPhong = NhanVien.MaPhong
GROUP BY PhongBan.TenPhong;
GO

--  Tính tổng tuổi của tất cả nhân viên
SELECT SUM(YEAR(GETDATE()) - YEAR(NhanVien.NgaySinh)) AS TongTuoi
FROM NhanVien;
GO

-- Lấy tên phòng và số lượng nhân viên trong mỗi phòng, chỉ hiển thị phòng có ít nhất 2 nhân viên
SELECT PhongBan.TenPhong, COUNT(NhanVien.MaNV) AS SoLuongNhanVien
FROM PhongBan
LEFT JOIN NhanVien ON PhongBan.MaPhong = NhanVien.MaPhong
GROUP BY PhongBan.TenPhong
HAVING COUNT(NhanVien.MaNV) >= 2;
GO

-- Sắp xếp nhân viên theo ngày sinh giảm dần
SELECT * FROM NhanVien
ORDER BY NgaySinh DESC;
GO

-- Lấy danh sách nhân viên sinh sau '1990-01-01' và làm việc ở phòng Kế Toán
SELECT *
FROM NhanVien
WHERE NgaySinh > '1990-01-01' AND MaPhong = (SELECT MaPhong FROM PhongBan WHERE TenPhong = 'Phòng Kế Toán');
GO

-- Sắp xếp nhân viên theo tên (tăng dần)
SELECT * FROM NhanVien
ORDER BY HoTen ASC;
GO

-- Lấy danh sách các phòng làm việc, loại bỏ các giá trị trùng lặp
SELECT DISTINCT TenPhong FROM PhongBan;
GO

-- Đếm số lượng nhân viên trong mỗi phòng làm việc
SELECT PhongBan.TenPhong, COUNT(NhanVien.MaNV) AS SoLuongNhanVien
FROM PhongBan
LEFT JOIN NhanVien ON PhongBan.MaPhong = NhanVien.MaPhong
GROUP BY PhongBan.TenPhong;
GO

--Tính tổng lương
SELECT SUM(Luong) AS TongLuong
FROM NhanVien
GO

-- Tính lương trung bình của tất cả nhân viên
SELECT AVG(Luong) AS LuongTrungBinh
FROM NhanVien;
GO

-- Lấy thông tin nhân viên có lương cao nhất
SELECT * FROM NhanVien
WHERE Luong = (SELECT MAX(Luong) FROM NhanVien);
GO

-- Lấy thông tin nhân viên có ngày sinh nhỏ nhất và lớn nhất
SELECT MIN(NgaySinh) AS NgaySinhNhoNhat, MAX(NgaySinh) AS NgaySinhLonNhat
FROM NhanVien;
GO

-- Lấy danh sách phòng có ít nhất 2 nhân viên
SELECT PhongBan.TenPhong, COUNT(NhanVien.MaNV) AS SoLuongNhanVien
FROM PhongBan
LEFT JOIN NhanVien ON PhongBan.MaPhong = NhanVien.MaPhong
GROUP BY PhongBan.TenPhong
HAVING COUNT(NhanVien.MaNV) >= 2;


