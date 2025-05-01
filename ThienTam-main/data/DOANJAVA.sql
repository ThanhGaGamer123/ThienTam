create database Thientam;
use Thientam;

	ALTER DATABASE Thientam SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
DROP DATABASE Thientam;

use master;

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
ALTER TABLE KhachHang
ADD tinhtrang BIT;

	CREATE TABLE GioHang (
    MaKH NVARCHAR(20) NOT NULL,
    MaThuoc NVARCHAR(20) NOT NULL,
    SoLuong INT NOT NULL,
    ThanhTien INT NOT NULL,
    DonGia INT NOT NULL,
    PRIMARY KEY (MaKH , MaThuoc)
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
	sdt VARCHAR(11),  
    manv VARCHAR(10),   
	tennguoinhan nvarchar(20),--
	sdtnguoinhan varchar(11),--
	phuong NVARCHAR(20),
	quan NVARCHAR(20),
	tinh NVARCHAR(20),  
	diachicuthe nvarchar(60),--
	    sanphammua NVARCHAR(1000),
    ngaydat VARCHAR(150), 
	ghichu nvarchar(100),--
    pttt NVARCHAR(50),            
    tongtien INT,
	tinhtrang NVARCHAR(50),       
);
DELETE FROM donhang;

drop table DonHang;

CREATE TABLE ChiTietDonHang (
    mactdh VARCHAR(10) PRIMARY KEY,          
    sl INT,                   
    thanhtien INT,      
    madon VARCHAR(10),
    sanphammua NVARCHAR(1000),
    diachicuthe NVARCHAR(100),
    macthdnhap VARCHAR(10),
    CONSTRAINT FK_ChiTietDonHang_DonHang FOREIGN KEY (madon) REFERENCES DonHang(madon)
);

DELETE FROM Chitietdonhang;

drop table Chitietdonhang;


CREATE TABLE ChiTietHoaDonNhap (
    macthdnhap VARCHAR(10) PRIMARY KEY,     
    mahdnhap VARCHAR(10),           
    gianhap VARCHAR(100),         
    thanhtien INT,       
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
    ngaynhap VARCHAR(10),                  
    tongtien INT,        
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

	delete from Thuoc
	delete from Kho

	ALTER TABLE DonHang DROP CONSTRAINT FK_DH_NV;






INSERT INTO KhachHang (MaKH, TenKH, SDT, Email, masonha , Duong, Phuong, Quan, Tinh, DiemKM, Passwordkh)
VALUES ('KH004', N'Lê Văn C', '0911222', 'abc@gmail.com', '789', N'Nguyễn Trãi', N'Phường 5', N'Quận 10', N'TP.HCM', 150, '123');

INSERT INTO KhachHang (MaKH, TenKH, SDT, Email, masonha, Duong, Phuong, Quan, Tinh, DiemKM, Passwordkh)
VALUES ('KH008', N'Xuân Thiện', '0398811258', 'x', '789', N'Nguyễn Trãi', N'Phường 5', N'Quận 10', N'TP.HCM', 15000000, 'x');

INSERT INTO KhachHang (MaKH, TenKH, SDT, Email, maSoNha, Duong, Phuong, Quan, Tinh, DiemKM, Passwordkh)
VALUES ('KH005', N'Huỳnh Xuân Thiện', '0366139854', 'z', '72', N'Nguyễn Trãi', N'Phường 5', N'Quận 10', N'TP.HCM', 1500000, 'z');

INSERT INTO KhachHang (MaKH, TenKH, SDT, Email, maSoNha, Duong, Phuong, Quan, Tinh, DiemKM, Passwordkh)
VALUES ('KH012', N'Lê Thị Hường ', '0366139999', 'q', '59', N'Phan Đăng Lưu ', N'Phường 5', N'Phú Nhuận', N'TP.HCM', 1500000, 'q');

UPDATE KhachHang SET tinhtrang = 1 WHERE MaKH = 'KH004';
UPDATE KhachHang SET tinhtrang = 1 WHERE MaKH = 'KH005';
UPDATE KhachHang SET tinhtrang = 1 WHERE MaKH = 'KH008';
UPDATE KhachHang SET tinhtrang = 1 WHERE MaKH = 'KH012';




DELETE FROM Thuoc;

INSERT INTO Thuoc (MaThuoc, TenThuoc, DonVi, ThanhPhan, ThongTin, XuatXu, DanhMuc, GiaBan, MaTon, DoiTuongSuDung, TinhTrang, hansudung) 
VALUES
('sp1', N'Viên uống hỗ trợ ngủ ngon', N'Hộp', N'Melatonin; L-Theanine', N'Hỗ trợ giấc ngủ sâu; giảm căng thẳng', N'Mỹ', N'Mất ngủ', '250000', 'ton01', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp2', N'Men vi sinh hỗ trợ tiêu hóa', N'Hộp', N'Lactobacillus; Bifidobacterium', N'Cân bằng hệ vi sinh đường ruột; hỗ trợ tiêu hóa', N'Mỹ', N'Rối loạn tiêu hóa', '300000', 'ton02', N'Mọi lứa tuổi', 1, DATEADD(YEAR, 3, GETDATE())),
('sp3', N'Viên uống bổ sung Vitamin C', N'Hộp', N'Vitamin C; Bioflavonoid', N'Tăng cường miễn dịch; chống oxy hóa', N'Mỹ', N'Suy giảm hệ miễn dịch', '120000', 'ton03', N'Mọi lứa tuổi', 1, DATEADD(YEAR, 3, GETDATE())),
('sp4', N'Trà thảo mộc nhuận tràng', N'Hộp', N'Trá Senna; Cam thảo', N'Hỗ trợ giảm táo bón; nhuận tràng tự nhiên', N'Việt Nam', N'Táo bón', '100000', 'ton04', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp5', N'Si-rô ăn ngon cho bé', N'Chai', N'Lysine; Vitamin B1; Kẽm', N'Hỗ trợ kích thích ăn ngon; tăng cân', N'Việt Nam', N'Biếng ăn', '150000', 'ton05', N'Trẻ em', 1, DATEADD(YEAR, 3, GETDATE())),
('sp6', N'Viên uống Ginkgo Biloba', N'Hộp', N'Chiết xuất lá bạch quả', N'Hỗ trợ tăng cường trí nhớ; tuần hoàn não', N'Đức', N'Suy giảm trí nhớ', '350000', 'ton06', N'Người lớn; Người cao tuổi', 1, DATEADD(YEAR, 3, GETDATE())),
('sp7', N'Viên uống hỗ trợ tim mạch Omega 3', N'Hộp', N'Dầu cá; EPA; DHA', N'Hỗ trợ giảm cholesterol; tốt cho tim mạch', N'Mỹ', N'Bệnh tim mạch', '280000', 'ton07', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp8', N'Viên uống tăng sức bền CoQ10', N'Hộp', N'Coenzyme Q10; Vitamin E', N'Hỗ trợ sản sinh năng lượng; giảm mệt mỏi', N'Nhật Bản', N'Mệt mỏi', '320000', 'ton08', N'Người lớn; Vận động viên', 1, DATEADD(YEAR, 3, GETDATE())),
('sp9', N'Viên uống giảm đau đầu Paracetamol', N'Hộp', N'Paracetamol', N'Giảm đau đầu; hạ sốt', N'Việt Nam', N'Đau đầu', '50000', 'ton09', N'Mọi lứa tuổi', 1, DATEADD(YEAR, 3, GETDATE())),
('sp10', N'Si-rô giảm ho có đàm', N'Hộp', N'Bạc hà; Cam thảo; Cát cánh', N'Hỗ trợ giảm ho; long đờm', N'Việt Nam', N'Ho có đàm', '90000', 'ton10', N'Mọi lứa tuổi', 1, DATEADD(YEAR, 3, GETDATE())),
('sp17', N'Viên nhai kích thích ăn ngon', N'Hộp', N'L-Lysine; Vitamin B Complex', N'Hỗ trợ bé ăn ngon; phát triển chiều cao', N'Úc', N'Biếng ăn', '190000', 'ton17', N'Trẻ em', 1, DATEADD(YEAR, 3, GETDATE())),
('sp18', N'Viên uống bổ não', N'Hộp', N'Omega 3; DHA; Phosphatidylserine', N'Hỗ trợ tăng cường trí nhớ; giảm stress', N'Mỹ', N'Suy giảm trí nhớ', '420000', 'ton18', N'Người lớn; Học sinh', 1, DATEADD(YEAR, 3, GETDATE())),
('sp19', N'Viên uống hỗ trợ tim mạch Red Yeast Rice', N'Hộp', N'Chiết xuất men gạo đỏ; CoQ10', N'Hỗ trợ giảm cholesterol; bảo vệ tim mạch', N'Mỹ', N'Bệnh tim mạch', '550000', 'ton19', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp20', N'Viên uống bổ sung năng lượng', N'Hộp', N'Vitamin B Complex; Iron; Magnesium', N'Hỗ trợ giảm mệt mỏi; tăng sức bền', N'Nhật Bản', N'Mệt mỏi', '320000', 'ton20', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp21', N'Viên uống chống đau nửa đầu', N'Hộp', N'Magnesium; Riboflavin; Feverfew', N'Hỗ trợ giảm đau nửa đầu', N'Pháp', N'Đau đầu', '450000', 'ton21', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp22', N'Si-rô trị ho có đờm', N'Hộp', N'Cam thảo; Mật ong; Cát cánh', N'Hỗ trợ giảm ho; làm dịu cổ họng', N'Việt Nam', N'Ho có đờm', '110000', 'ton22', N'Mọi lứa tuổi', 1, DATEADD(YEAR, 3, GETDATE())),
('sp23', N'Viên uống hỗ trợ tiêu hóa cho người lớn', N'Hộp', N'Lactobacillus; Inulin', N'Hỗ trợ tiêu hóa; cân bằng hệ vi sinh', N'Nhật Bản', N'Rối loạn tiêu hóa', '150000', 'ton23', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp24', N'Si-rô tăng cường miễn dịch', N'Chai', N'Vitamin C; Beta-glucan', N'Hỗ trợ hệ miễn dịch', N'Mỹ', N'Suy giảm hệ miễn dịch', '250000', 'ton24', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp25', N'Viên uống hỗ trợ giảm đau khớp', N'Hộp', N'Glucosamine; Chondroitin', N'Hỗ trợ giảm đau và phục hồi khớp', N'Việt Nam', N'Mệt mỏi', '350000', 'ton25', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp26', N'Trái cây khô hỗ trợ tiêu hóa', N'Chai', N'Enzyme; Dứa; Papaya', N'Hỗ trợ hệ tiêu hóa khỏe mạnh', N'Úc', N'Rối loạn tiêu hóa', '130000', 'ton26', N'Mọi lứa tuổi', 1, DATEADD(YEAR, 3, GETDATE())),
('sp27', N'Viên uống giúp giảm lo âu', N'Hộp', N'Lavender; Valerian', N'Hỗ trợ giảm lo âu và căng thẳng', N'Anh', N'Mất ngủ', '200000', 'ton27', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp28', N'Viên uống hỗ trợ sinh lý nam', N'Hộp', N'Ginseng; L-Arginine', N'Tăng cường sinh lý nam', N'Việt Nam', N'Mệt mỏi', '450000', 'ton28', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp29', N'Si-rô bổ sung Vitamin C cho trẻ', N'Chai', N'Vitamin C; Zinc', N'Tăng cường sức đề kháng cho trẻ', N'Nhật Bản', N'Suy giảm hệ miễn dịch', '100000', 'ton29', N'Trẻ em', 1, DATEADD(YEAR, 3, GETDATE())),
('sp30', N'Viên uống bổ não cho người cao tuổi', N'Hộp', N'Omega 3; Vitamin B12', N'Hỗ trợ trí nhớ và giảm stress', N'Mỹ', N'Suy giảm trí nhớ', '450000', 'ton30', N'Người cao tuổi', 1, DATEADD(YEAR, 3, GETDATE())),
('sp31', N'Viên uống giảm mỡ máu', N'Hộp', N'Chiết xuất trà xanh; Omega 3', N'Hỗ trợ giảm mỡ máu và cholesterol', N'Nhật Bản', N'Bệnh tim mạch', '550000', 'ton31', N'Người lớn', 1, DATEADD(YEAR, 3, GETDATE())),
('sp32', N'Si-rô trị ho cho trẻ em', N'Chai', N'Mật ong; Quế', N'Hỗ trợ giảm ho, long đờm cho trẻ', N'Việt Nam', N'Ho có đờm', '80000', 'ton32', N'Trẻ em', 1, DATEADD(YEAR, 3, GETDATE()));




INSERT INTO Kho (MaTon, slton, tinhtrang) 
VALUES
('ton01', 100, 1),
('ton02', 200, 1),
('ton03', 150, 1),
('ton04', 120, 1),
('ton05', 80, 1),
('ton06', 90, 1),
('ton07', 110, 1),
('ton08', 75, 1),
('ton09', 130, 1),
('ton10', 95, 1),
('ton11', 85, 1),   -- Bổ sung cho sản phẩm tiếp theo
('ton12', 140, 1),  -- Men tiêu hóa cho trẻ
('ton13', 90, 1),   -- Viên uống tỏi đen
('ton14', 110, 1),  -- Trà hỗ trợ tiêu hóa
('ton15', 130, 1),  -- Si-rô tăng sức đề kháng
('ton16', 95, 1),   -- Viên uống bổ sung chất xơ
('ton17', 100, 1),  -- Viên nhai kích thích ăn ngon
('ton18', 150, 1),  -- Viên uống bổ não
('ton19', 200, 1),  -- Viên uống hỗ trợ tim mạch Red Yeast Rice
('ton20', 120, 1),  -- Viên uống bổ sung năng lượng
('ton21', 130, 1),  -- Viên uống chống đau nửa đầu
('ton22', 180, 1);  -- Si-rô trị ho có đờm


INSERT INTO Kho (MaTon, slton, tinhtrang) 
VALUES
('ton23', 160, 1),  -- Viên uống hỗ trợ tiêu hóa cho người lớn
('ton24', 110, 1),  -- Si-rô tăng cường miễn dịch
('ton25', 180, 1),  -- Viên uống hỗ trợ giảm đau khớp
('ton26', 95, 1),   -- Trái cây khô hỗ trợ tiêu hóa
('ton27', 120, 1),  -- Viên uống giúp giảm lo âu
('ton28', 140, 1),  -- Viên uống hỗ trợ sinh lý nam
('ton29', 200, 1),  -- Si-rô bổ sung Vitamin C cho trẻ
('ton30', 150, 1),  -- Viên uống bổ não cho người cao tuổi
('ton31', 220, 1),  -- Viên uống giảm mỡ máu
('ton32', 180, 1);  -- Si-rô trị ho cho trẻ em




