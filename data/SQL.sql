create database Thientam;
use Thientam;
use master;
drop database Thientam;
CREATE TABLE NhaThuoc (
    mant‎ VARCHAR(10) PRIMARY KEY,     
    masonha‎ NVARCHAR(20),
	duong NVARCHAR(50),
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),        
    manql VARCHAR(10),           
);

CREATE TABLE NhanVien (
    manv VARCHAR(10) PRIMARY KEY,         
    tennv NVARCHAR(100),         
    chucvu NVARCHAR(50),  
	sdt VARCHAR(11),
    masonha NVARCHAR(20),
	duong NVARCHAR(50),
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),    
    username NVARCHAR(50),  
    passwordnv NVARCHAR(50),         
    manhathuoc VARCHAR(10),               
);

CREATE TABLE KhachHang (
    makh VARCHAR(10) PRIMARY KEY,          
    tenkh NVARCHAR(100),          
    sdt VARCHAR(11),                
    email VARCHAR(100),             
    masonha NVARCHAR(20),
	duong NVARCHAR(50),
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),                
    diemkm INT, 
    passwordkh VARCHAR(50),
);

CREATE TABLE ChiTietKM (
    mactkm VARCHAR(10) PRIMARY KEY,         
    madon VARCHAR(10),             
    makm VARCHAR(10), 
	ngayapdung VARCHAR(10),
);

CREATE TABLE ChuongTrinhKhuyenMai (
    makm VARCHAR(10) PRIMARY KEY,          
    tenkm NVARCHAR(100),           
    ngaybatdau VARCHAR(10),                   
    ngayketthuc VARCHAR(10),                   
    noidung NVARCHAR(200),      
	diem INT,
);

CREATE TABLE DonHang (
    madon VARCHAR(10) PRIMARY KEY,          
    makh VARCHAR(10),             
    manv VARCHAR(10),   
	masonha NVARCHAR(20),
	duong NVARCHAR(50),
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),                   
    ngaydat VARCHAR(10),                 
    pttt NVARCHAR(50),            
    tinhtrang NVARCHAR(50),       
    tongtien INT,      
);

CREATE TABLE ChiTietDonHang (
    mactdh VARCHAR(10) PRIMARY KEY,          
    sl INT,                   
    thanhtien INT,      
    madon VARCHAR(10),             
    dongia INT,         
    macthdnhap VARCHAR(10),            
);

CREATE TABLE ChiTietHoaDonNhap (
    macthdnhap VARCHAR(10) PRIMARY KEY,     
    mahdnhap VARCHAR(10),           
    gianhap VARCHAR(100),         
    thanhtien INT,       
    slnhap VARCHAR(100),
	slcon VARCHAR(100),
    mathuoc VARCHAR(10),       
);

CREATE TABLE Thuoc (
    mathuoc VARCHAR(10) PRIMARY KEY,       
    tenthuoc NVARCHAR(100),
	donvi NVARCHAR(100),
    thanhphan NVARCHAR(255),                 
    thongtin NVARCHAR(500),                       
    xuatxu NVARCHAR(50),                     
    danhmuc NVARCHAR(100),  
	giaban VARCHAR(100),              
	maton VARCHAR(10),
	doituongsudung NVARCHAR(100),
);

CREATE TABLE HoaDonNhap (
    mahdnhap VARCHAR(10) PRIMARY KEY,        
    mancc VARCHAR(10),              
    soloaithuoc INT,                
    ngaynhap VARCHAR(10),                  
    tongtien INT,        
);

CREATE TABLE NhaCungCap (
    mancc VARCHAR(10) PRIMARY KEY,          
    tenncc NVARCHAR(100),        
	sdt VARCHAR(11),
    masonha NVARCHAR(20),
	duong NVARCHAR(50),
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),            
);

CREATE TABLE Kho (
    maton VARCHAR(10) PRIMARY KEY,
    slton VARCHAR(100),
);

    ALTER TABLE NhaThuoc ADD CONSTRAINT FK_NhaThuoc_NV FOREIGN KEY (manql) REFERENCES NhanVien(manv);
    ALTER TABLE NhanVien ADD CONSTRAINT FK_NV_NhaThuoc FOREIGN KEY (manhathuoc) REFERENCES NhaThuoc(mant);
    ALTER TABLE ChiTietKM ADD CONSTRAINT FK_CTKM_DH FOREIGN KEY (madon) REFERENCES DonHang(madon);
	ALTER TABLE ChiTietKM ADD CONSTRAINT FK_CTKM_CTRKM FOREIGN KEY (makm) REFERENCES ChuongTrinhKhuyenMai(makm);
	ALTER TABLE DonHang ADD CONSTRAINT FK_DH_KH FOREIGN KEY (makh) REFERENCES KhachHang(makh);
	ALTER TABLE DonHang ADD CONSTRAINT FK_DH_NV FOREIGN KEY (manv) REFERENCES NhanVien(manv);
	ALTER TABLE ChiTietDonHang ADD CONSTRAINT FK_CTDH_DH FOREIGN KEY (madon) REFERENCES DonHang(madon);
    ALTER TABLE ChiTietDonHang ADD CONSTRAINT FK_CTDH_CTHDN FOREIGN KEY (macthdnhap) REFERENCES ChiTietHoaDonNhap(macthdnhap);
	ALTER TABLE HoaDonNhap ADD CONSTRAINT FK_HDN_NCC FOREIGN KEY (mancc) REFERENCES NhaCungCap(mancc);
	ALTER TABLE ChiTietHoaDonNhap ADD CONSTRAINT FK_CTHDN_HDN FOREIGN KEY (mahdnhap) REFERENCES HoaDonNhap(mahdnhap); 
    ALTER TABLE ChiTietHoaDonNhap ADD CONSTRAINT FK_CTHDN_Thuoc FOREIGN KEY (mathuoc) REFERENCES Thuoc(mathuoc);
	ALTER TABLE Thuoc ADD CONSTRAINT FK_Thuoc_Kho FOREIGN KEY (maton) REFERENCES Kho(maton);