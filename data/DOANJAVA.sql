create database Thientam
use Thientam;
use master;
drop database Thientam;
CREATE TABLE NhaThuoc (
    MaNhaThuoc VARCHAR(10) PRIMARY KEY,     
    SoNha VARCHAR(20),
	Duong VARCHAR(50),
	Phuong VARCHAR(20),
	Quan VARCHAR(20),
	Tinh VARCHAR(20),        
    MaNQL VARCHAR(10) NOT NULL,           
);

CREATE TABLE NhanVien (
    MaNV VARCHAR(10) PRIMARY KEY,         
    TenNV NVARCHAR(100) NOT NULL,         
    ChucVu NVARCHAR(50) NOT NULL,  
	SDT VARCHAR(11),
    SoNha VARCHAR(20),
	Duong VARCHAR(50),
	Phuong VARCHAR(20),
	Quan VARCHAR(20),
	Tinh VARCHAR(20),    
    Username VARCHAR(50) UNIQUE NOT NULL,  
    Passwordnv VARCHAR(50) NOT NULL,         
    MaNhaThuoc VARCHAR(10),               
);

CREATE TABLE KhachHang (
    MaKH VARCHAR(10) PRIMARY KEY,          
    TenKH NVARCHAR(100) NOT NULL,          
    SDT VARCHAR(15) UNIQUE,                
    Email VARCHAR(100) UNIQUE,             
    SoNha VARCHAR(20),
	Duong VARCHAR(50),
	Phuong VARCHAR(20),
	Quan VARCHAR(20),
	Tinh VARCHAR(20),                
    DiemKM INT DEFAULT 0 CHECK (DiemKM >= 0), 
    Passwordkh VARCHAR(50) NOT NULL          
);

CREATE TABLE ChiTietKM (
    MaCTKM VARCHAR(10) PRIMARY KEY,         
    MaDon VARCHAR(10) NOT NULL,             
    MaCTRKM VARCHAR(10),     
);

CREATE TABLE ChuongTrinhKhuyenMai (
    MaCTRKM VARCHAR(10) PRIMARY KEY,          
    TenCT NVARCHAR(100) NOT NULL,           
    NgayBD DATE NOT NULL,                   
    NgayKT DATE NOT NULL,                   
    NoiDungKM NVARCHAR(200),                
    -- Ràng buộc kiểm tra ngày kết thúc lớn hơn hoặc bằng ngày bắt đầu
    CONSTRAINT CHK_Ngay CHECK (NgayKT >= NgayBD)
);

CREATE TABLE DonHang (
    MaDon VARCHAR(10) PRIMARY KEY,          
    MaKH VARCHAR(10) NOT NULL,             
    MaNV VARCHAR(10),   
	SoNha VARCHAR(20),
	Duong VARCHAR(50),
	Phuong VARCHAR(20),
	Quan VARCHAR(20),
	Tinh VARCHAR(20),                   
    NgayDat DATE NOT NULL,                 
    PTTT NVARCHAR(50) NOT NULL,            
    TinhTrang NVARCHAR(50) NOT NULL,       
    TongTien DECIMAL(15, 2) NOT NULL,      
);

CREATE TABLE ChiTietDonHang (
    MaCTDH VARCHAR(10) PRIMARY KEY,          
    SoLuong INT NOT NULL,                   
    ThanhTien DECIMAL(15, 2) NOT NULL,      
    MaDon VARCHAR(10) NOT NULL,             
    DonGia DECIMAL(15, 2) NOT NULL,         
    MaCTHDNhap VARCHAR(10),            
);

CREATE TABLE ChiTietHoaDonNhap (
    MaCTHDNhap VARCHAR(10) PRIMARY KEY,     
    MaHDNhap VARCHAR(10) NOT NULL,           
    DonGia DECIMAL(15, 2) NOT NULL,         
    ThanhTien DECIMAL(15, 2) NOT NULL,       
    SoLuongNhap INT NOT NULL,                
    MaThuoc VARCHAR(10) NOT NULL,       
);

CREATE TABLE Thuoc (
    MaThuoc VARCHAR(10) PRIMARY KEY,       
    TenThuoc NVARCHAR(100) NOT NULL,
	DonVi NVARCHAR(500),
    ThanhPhan NVARCHAR(255),                 
    TTinThuoc NVARCHAR(500),                       
    XuatXu NVARCHAR(50),                     
    DanhMuc NVARCHAR(100),  
	GiaBan VARCHAR(100) NOT NULL,              
    GiaNhap VARCHAR(100) NOT NULL,
	MaTon VARCHAR(10),
);

CREATE TABLE HoaDonNhap (
    MaHDNhap VARCHAR(10) PRIMARY KEY,        
    MaNCC VARCHAR(10) NOT NULL,              
    SoLoaiThuoc INT NOT NULL,                
    NgayNhap DATE NOT NULL,                  
    TongTien DECIMAL(15, 2) NOT NULL,        
);

CREATE TABLE NhaCungCap (
    MaNCC VARCHAR(10) PRIMARY KEY,          
    TenNCC NVARCHAR(100) NOT NULL,           
    SoNha VARCHAR(20),
	Duong VARCHAR(50),
	Phuong VARCHAR(20),
	Quan VARCHAR(20),
	Tinh VARCHAR(20),            
);

CREATE TABLE Kho (
    MaTon VARCHAR(10) PRIMARY KEY,
    SoLuongTon VARCHAR(100),
);

    ALTER TABLE NhaThuoc ADD CONSTRAINT FK_MaNQL FOREIGN KEY (MaNQL) REFERENCES NhanVien(MaNV);
    ALTER TABLE NhanVien ADD CONSTRAINT FK_MaNhaThuoc FOREIGN KEY (MaNhaThuoc) REFERENCES NhaThuoc(MaNhaThuoc);
    ALTER TABLE ChiTietKM ADD CONSTRAINT FK_MaDon FOREIGN KEY (MaDon) REFERENCES DonHang(MaDon);
	ALTER TABLE ChiTietKM ADD CONSTRAINT FK_MaCTRKM FOREIGN KEY (MaCTRKM) REFERENCES ChuongTrinhKhuyenMai(MaCTRKM);
	ALTER TABLE DonHang ADD CONSTRAINT FK_MaKH FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH);
	ALTER TABLE DonHang ADD CONSTRAINT FK_MaNV FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV);
	ALTER TABLE ChiTietDonHang ADD CONSTRAINT FK_MaDon FOREIGN KEY (MaDon) REFERENCES DonHang(MaDon);
    ALTER TABLE ChiTietDonHang ADD CONSTRAINT FK_MaCTHDNhap FOREIGN KEY (MaCTHDNhap) REFERENCES ChiTietHoaDonNhap(MaCTHDNhap);
	ALTER TABLE HoaDonNhap ADD CONSTRAINT FK_MaNCC FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC);
	ALTER TABLE ChiTietHoaDonNhap ADD CONSTRAINT FK_MaHDNhap FOREIGN KEY (MaHDNhap) REFERENCES HoaDonNhap(MaHDNhap); 
    ALTER TABLE ChiTietHoaDonNhap ADD CONSTRAINT FK_MaThuoc FOREIGN KEY (MaThuoc) REFERENCES Thuoc(MaThuoc);
	ALTER TABLE Thuoc ADD CONSTRAINT FK_MaTon FOREIGN KEY (MaTon) REFERENCES Kho(MaTon);