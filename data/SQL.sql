create database Thientam;
use Thientam;
use master;
drop database Thientam;
CREATE TABLE NhaThuoc (
    mant VARCHAR(10) PRIMARY KEY,     
    masonha NVARCHAR(20),
	duong NVARCHAR(50),
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),        
    manql VARCHAR(10),    
	tinhtrang BIT
)

insert into NhaThuoc values ('NT0001', N'267', N'Mã Lò', N'Bình Trị Đông A', N'Bình Tân', N'TPHCM', null, 1);

CREATE TABLE NhanVien (
    manv VARCHAR(10) PRIMARY KEY,         
    tennv NVARCHAR(100),         
    chucvu NVARCHAR(50),  
	gioitinh NVARCHAR(5),
	cccd NVARCHAR(15),
	sdt VARCHAR(11),
    masonha NVARCHAR(20),
	duong NVARCHAR(50),
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),    
    username NVARCHAR(50),  
    passwordnv NVARCHAR(50),         
    manhathuoc VARCHAR(10),   
	tinhtrang BIT
);

insert into NhanVien values ('NV0001', N'Nguyễn Văn A', N'quản lý', N'Nam', N'1231231234', 1231231234,
N'267', N'Mã Lò', N'Bình Trị Đông A', N'Bình Tân', N'TPHCM', N'nv1', N'123', 'NT0001', 1);
update NhaThuoc set manql = 'NV0001' where mant = 'NT0001';

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
	tinhtrang BIT,
);
insert into KhachHang values ('KH0001', N'Tran Linh C', '0904221123', 'tranlinhchi@gmail.com', '267',
N'Mã Lò', N'Bình Trị Đông A', N'Bình Tân', N'TPHCM', 9999, '123', 1);
insert into KhachHang values ('KH0002', N'Vu Dinh T', '0904221123', 'vudinhT@gmail.com', '267',
N'Mã Lò', N'Bình Trị Đông A', N'Bình Tân', N'TPHCM', 9999, '123', 1);
select * from KhachHang where tinhtrang = 'True'

CREATE TABLE GioHang (
    makh VARCHAR(10) PRIMARY KEY,
    mathuoc VARCHAR(10),
    soluong INT,
    thanhtien DECIMAL,
    dongia DECIMAL,
);

CREATE TABLE ChiTietKM (
    mactkm VARCHAR(10) PRIMARY KEY,         
    madon VARCHAR(10),             
    makm VARCHAR(10), 
	ngayapdung VARCHAR(100),
	tinhtrang BIT,
);

CREATE TABLE ChuongTrinhKhuyenMai (
    makm VARCHAR(10) PRIMARY KEY,          
    tenkm NVARCHAR(100),           
    ngaybatdau VARCHAR(10),                   
    ngayketthuc VARCHAR(10),    
	giam INT,
    noidung NVARCHAR(200),      
	diem INT,
	tinhtrang BIT,
);
insert into ChuongTrinhKhuyenMai values ('KM0001', N'Kỉ Niệm 30/4', N'30/04/2025', N'31/05/2025', 10, 
N'Chào mừng 50 năm giải phóng miền Nam thống nhất đất nước.', 0, 1);
insert into ChuongTrinhKhuyenMai values ('KM0002', N'Sale Cuối Tuần', N'30/04/2025', N'31/05/2025', 10, 
N'Cuối tuần sale cực hot.', 1000, 1);
insert into ChuongTrinhKhuyenMai values ('KM0003', N'ADMIN', N'30/04/2025', N'31/05/2025', 100, 
N'Admin.', 99999999, 1);

select * from ChuongTrinhKhuyenMai where tinhtrang = 1

CREATE TABLE DonHang (
    madon VARCHAR(10) PRIMARY KEY,          
    makh VARCHAR(10),             
    manv VARCHAR(10),   
	masonha NVARCHAR(20),
	duong NVARCHAR(50),
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),                   
    ngaydat VARCHAR(100),                 
    pttt NVARCHAR(50),            
    tinhtrang NVARCHAR(50),       
    tongtien DECIMAL,
	ghichu NVARCHAR(1000),
	nguoinhan NVARCHAR(100),
	sdt_nguoinhan INT,
);

select * from DonHang where madon like N'%DH0001%' and makh like N'%KH0001%' 
and manv like N'%NV0001%' and pttt like N'%Trả bằng tiền mặt%' and tinhtrang like N'%Đang xử lý%'

CREATE TABLE ChiTietDonHang (
    mactdh VARCHAR(10) PRIMARY KEY,
	donvi NVARCHAR(10),
    sl INT,                   
    thanhtien DECIMAL,      
    madon VARCHAR(10),             
    dongia DECIMAL,         
    macthdnhap VARCHAR(10),
	tinhtrang BIT
);

CREATE TABLE ChiTietHoaDonNhap (
    macthdnhap VARCHAR(10) PRIMARY KEY,     
    mahdnhap VARCHAR(10),           
    gianhap VARCHAR(100),         
    thanhtien DECIMAL,       
    slnhap VARCHAR(100),
	slcon VARCHAR(100),
    mathuoc VARCHAR(10),    
	tinhtrang BIT
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
	hansudung NVARCHAR(50),
	tinhtrang BIT
);

CREATE TABLE HoaDonNhap (
    mahdnhap VARCHAR(10) PRIMARY KEY,        
    mancc VARCHAR(10),              
    soloaithuoc INT,                
    ngaynhap VARCHAR(100),                  
    tongtien DECIMAL,        
	tinhtrang BIT
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
	tinhtrang BIT
);

insert into NhaCungCap values ('NCC0001', N'Thái An', 1231231234, N'267', N'Mã Lò', N'Bình Trị Đông A',
N'Bình Tân', N'TPHCM', 1);

CREATE TABLE Kho (
    maton VARCHAR(10) PRIMARY KEY,
    slton VARCHAR(100),
	tinhtrang BIT
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
ALTER TABLE GioHang ADD CONSTRAINT FK_GioHang_KhachHang FOREIGN KEY (maKH) REFERENCES KhachHang(maKH);

delete from ChiTietDonHang
delete from ChiTietKM
delete from DonHang
delete from ChiTietHoaDonNhap
delete from HoaDonNhap
delete from Thuoc
delete from Kho