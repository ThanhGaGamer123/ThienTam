create database Thientam;
use Thientam;
use master;
drop database Thientam;
CREATE TABLE NhaThuoc (
    mant‎ VARCHAR(10) PRIMARY KEY,     
    masonha‎ VARCHAR(20),
	duong VARCHAR(50),
	phuong VARCHAR(20),
	quan VARCHAR(20),
	tinh VARCHAR(20),        
    manql VARCHAR(10),           
);

CREATE TABLE NhanVien (
    manv VARCHAR(10) PRIMARY KEY,         
    tennv NVARCHAR(100),         
    chucvu NVARCHAR(50),  
	sdt VARCHAR(11),
    masonha VARCHAR(20),
	duong VARCHAR(50),
	phuong VARCHAR(20),
	quan VARCHAR(20),
	tinh VARCHAR(20),    
    username VARCHAR(50),  
    passwordnv VARCHAR(50),         
    manhathuoc VARCHAR(10),               
);

CREATE TABLE KhachHang (
    makh VARCHAR(10) PRIMARY KEY,          
    tenkh NVARCHAR(100),          
    sdt VARCHAR(11),                
    email VARCHAR(100),             
    masonha VARCHAR(20),
	duong VARCHAR(50),
	phuong VARCHAR(20),
	quan VARCHAR(20),
	tinh VARCHAR(20),                
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
	masonha VARCHAR(20),
	duong VARCHAR(50),
	phuong VARCHAR(20),
	quan VARCHAR(20),
	tinh VARCHAR(20),                   
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
    mathuoc VARCHAR(10),       
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
    masonha VARCHAR(20),
	duong VARCHAR(50),
	phuong VARCHAR(20),
	quan VARCHAR(20),
	tinh VARCHAR(20),            
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


-- Chèn dữ liệu vào bảng KhachHang (đồng nhất tên cột với bảng)
INSERT INTO KhachHang (MaKH, TenKH, SDT, Email, Masonha, Duong, Phuong, Quan, Tinh, DiemKM, Passwordkh)
VALUES ('KH004', N'Lê Văn C', '0911222', 'abc@gmail.com', '789', N'Nguyễn Trãi', N'Phường 5', N'Quận 10', N'TP.HCM', 150, '123');

INSERT INTO KhachHang (MaKH, TenKH, SDT, Email, Masonha, Duong, Phuong, Quan, Tinh, DiemKM, Passwordkh)
VALUES ('KH008', N'Xuân Thiện', '0398811258', 'x', '789', N'Nguyễn Trãi', N'Phường 5', N'Quận 10', N'TP.HCM', 150, 'x');





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


INSERT INTO Thuoc (MaThuoc, TenThuoc, DonVi, thanhphan, ThongTin, XuatXu, DanhMuc, GiaBan, MaTon, Doituongsudung) 
VALUES

('sp2', N'Men vi sinh hỗ trợ tiêu hóa', N'Hộp', N'Lactobacillus; Bifidobacterium', N'Cân bằng hệ vi sinh đường ruột; hỗ trợ tiêu hóa', N'Mỹ', N'Rối loạn tiêu hóa', '300000', N'ton02', N'Mọi lứa tuổi'),
('sp3', N'Viên uống bổ sung Vitamin C', N'Hộp', N'Vitamin C; Bioflavonoid', N'Tăng cường miễn dịch; chống oxy hóa', N'Mỹ', N'Suy giảm hệ miễn dịch', '120000', N'ton03', N'Mọi lứa tuổi'),
('sp4', N'Trà thảo mộc nhuận tràng', N'Hộp', N'Trá Senna; Cam thảo', N'Hỗ trợ giảm táo bón; nhuận tràng tự nhiên', N'Việt Nam', N'Táo bón', '100000', N'ton04', N'Người lớn'),
('sp5', N'Si-rô ăn ngon cho bé', N'Chai', N'Lysine; Vitamin B1; Kẽm', N'Hỗ trợ kích thích ăn ngon; tăng cân', N'Việt Nam', N'Biếng ăn', '150000', N'ton05', N'Trẻ em'),
('sp6', N'Viên uống Ginkgo Biloba', N'Hộp', N'Chiết xuất lá bạch quả', N'Hỗ trợ tăng cường trí nhớ; tuần hoàn não', N'Đức', N'Suy giảm trí nhớ', '350000', N'ton06', N'Người lớn'),
('sp7', N'Viên uống hỗ trợ tim mạch Omega 3', N'Hộp', N'Dầu cá; EPA; DHA', N'Hỗ trợ giảm cholesterol; tốt cho tim mạch', N'Mỹ', N'Bệnh tim mạch', '280000', N'ton07', N'Người lớn'),
('sp8', N'Viên uống tăng sức bền CoQ10', N'Hộp', N'Coenzyme Q10; Vitamin E', N'Hỗ trợ sản sinh năng lượng; giảm mệt mỏi', N'Nhật Bản', N'Mệt mỏi', '320000', N'ton08', N'Người lớn'),
('sp9', N'Viên uống giảm đau đầu Paracetamol', N'Hộp', N'Paracetamol', N'Giảm đau đầu; hạ sốt', N'Việt Nam', N'Đau đầu', '50000', N'ton09', N'Mọi lứa tuổi'),
('sp10', N'Si-rô giảm ho có đàm', N'Hộp', N'Bạc hà; Cam thảo; Cát cánh', N'Hỗ trợ giảm ho; long đờm', N'Việt Nam', N'Ho có đờm', '90000', N'ton10', N'Mọi lứa tuổi'),
('sp11', N'Viên uống hỗ trợ ngủ sâu', N'Hộp', N'Valerian Root; Chamomile', N'Hỗ trợ thư giãn; ngủ ngon', N'Mỹ', N'Mất ngủ', '280000', N'ton11', N'Người lớn'),
('sp12', N'Men tiêu hóa cho trẻ', N'Hộp', N'Probiotic; Kẽm', N'Hỗ trợ hệ tiêu hóa khỏe mạnh', N'Nhật Bản', N'Rối loạn tiêu hóa', '150000', N'ton12', N'Trẻ em'),
('sp13', N'Viên uống tỏi đen', N'Hộp', N'Chiết xuất tỏi đen', N'Tăng cường hệ miễn dịch; hỗ trợ tim mạch', N'Nhật Bản', N'Suy giảm hệ miễn dịch', '320000', N'ton13', N'Người lớn'),
('sp14', N'Trà hỗ trợ tiêu hóa', N'Hộp', N'Trà gừng; Tiêu đen', N'Hỗ trợ tiêu hóa; giảm đầy hơi', N'Việt Nam', N'Rối loạn tiêu hóa', '120000', N'ton14', N'Người lớn'),
('sp15', N'Si-rô tăng sức đề kháng', N'Hộp', N'Vitamin C; Kẽm; Beta-glucan', N'Hỗ trợ tăng sức đề kháng', N'Mỹ', N'Suy giảm hệ miễn dịch', '180000', N'ton15', N'Trẻ em'),
('sp16', N'Viên uống bổ sung chất xơ', N'Hộp', N'Inulin; Psyllium Husk', N'Hỗ trợ tiêu hóa; giảm táo bón', N'Mỹ', N'Táo bón', '220000', N'ton16', N'Người lớn'),
('sp17', N'Viên nhai kích thích ăn ngon', N'Hộp', N'L-Lysine; Vitamin B Complex', N'Hỗ trợ bé ăn ngon; phát triển chiều cao', N'Úc', N'Biếng ăn', '190000', N'ton17', N'Trẻ em'),
('sp18', N'Viên uống bổ não', N'Hộp', N'Omega 3; DHA; Phosphatidylserine', N'Hỗ trợ tăng cường trí nhớ; giảm stress', N'Mỹ', N'Suy giảm trí nhớ', '420000', N'ton18', N'Người lớn'),
('sp19', N'Viên uống hỗ trợ tim mạch Red Yeast Rice', N'Hộp', N'Chiết xuất men gạo đỏ; CoQ10', N'Hỗ trợ giảm cholesterol; bảo vệ tim mạch', N'Mỹ', N'Bệnh tim mạch', '550000', N'ton19', N'Người lớn'),
('sp20', N'Viên uống bổ sung năng lượng', N'Hộp', N'Vitamin B Complex; Iron; Magnesium', N'Hỗ trợ giảm mệt mỏi; tăng sức bền', N'Nhật Bản', N'Mệt mỏi', '320000', N'ton20', N'Người lớn'),
('sp21', N'Viên uống chống đau nửa đầu', N'Hộp', N'Magnesium; Riboflavin; Feverfew', N'Hỗ trợ giảm đau nửa đầu', N'Pháp', N'Đau đầu', '450000', N'ton21', N'Người lớn'),
('sp22', N'Si-rô trị ho có đờm', N'Hộp', N'Cam thảo; Mật ong; Cát cánh', N'Hỗ trợ giảm ho; làm dịu cổ họng', N'Việt Nam', N'Ho có đờm', '110000', N'ton22', N'Mọi lứa tuổi'),
('sp23', N'Viên uống hỗ trợ sức khỏe tim mạch', N'Hộp', N'Omega 3; Coenzyme Q10', N'Hỗ trợ tăng cường sức khỏe tim mạch', N'Mỹ', N'Bệnh tim mạch', '500000', N'ton23', N'Người lớn');


DELETE FROM Thuoc;

INSERT INTO Kho (MaTon, slton)
VALUES
('ton01', '100'),
('ton02', '200'),
('ton03', '150'),
('ton04', '120'),
('ton05', '80'),
('ton06', '90'),
('ton07', '110'),
('ton08', '75'),
('ton09', '130'),
('ton10', '95'),
('ton11', '85'),   -- Bổ sung cho sản phẩm tiếp theo
('ton12', '140'),  -- Men tiêu hóa cho trẻ
('ton13', '90'),   -- Viên uống tỏi đen
('ton14', '110'),  -- Trà hỗ trợ tiêu hóa
('ton15', '130'),  -- Si-rô tăng sức đề kháng
('ton16', '95'),   -- Viên uống bổ sung chất xơ
('ton17', '100'),  -- Viên nhai kích thích ăn ngon
('ton18', '150'),  -- Viên uống bổ não
('ton19', '200'),  -- Viên uống hỗ trợ tim mạch Red Yeast Rice
('ton20', '120'),  -- Viên uống bổ sung năng lượng
('ton21', '130'),  -- Viên uống chống đau nửa đầu
('ton22', '180');  -- S

INSERT INTO Kho (MaTon, slton)
VALUES
('ton23', '150');




