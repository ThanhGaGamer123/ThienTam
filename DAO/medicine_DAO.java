package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.medicine_DTO;
import advanceMethod.advance;

public class medicine_DAO implements DAO<medicine_DTO> {
    @Override
    public int add(medicine_DTO t) {
        //B1: kết nối csdl
        Connection sql = data.SQL.createConnection();

        //B2: tạo câu lệnh SQL
        String command = "INSERT INTO Thuoc (mathuoc, tenthuoc, donvi, thanhphan, thongtin, xuatxu, danhmuc, giaban, maton, doituongsudung, hansudung, tinhtrang) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        //B3: tạo prepare statement
        try (PreparedStatement pst = sql.prepareStatement(command)) {
            // Gán giá trị cho các tham số
            pst.setString(1, t.getMathuoc());
            pst.setString(2, t.getTenthuoc());
            pst.setString(3, advance.StringArrayListToString(t.getDonvi()));
            pst.setString(4, t.getThanhphan());
            pst.setString(5, t.getThongtin());
            pst.setString(6, t.getXuatxu());
            pst.setString(7, t.getDanhmuc());
            pst.setString(8, advance.DoubleArrayListToString(t.getGiaban()));
            pst.setString(9, t.getMaton());
            pst.setString(10, advance.StringArrayListToString(t.getDoituongsudung()));
            pst.setString(11, t.getHansudung());
            pst.setBoolean(12, t.getTinhtrang());

            // B3: Thực thi câu lệnh
            int ketQua = pst.executeUpdate();

            // B4: Xử lý kết quả
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // B5: Ngắt kết nối
            data.SQL.closeConnection(sql);
        }

        return 0;
    }

    @Override
    public int update(medicine_DTO t) {
        //B1: kết nối csdl
        Connection sql = data.SQL.createConnection();

        //B2: tạo câu lệnh SQL
        String command = "UPDATE Thuoc SET tenthuoc = ?, donvi = ?, thanhphan = ?, thongtin = ?, xuatxu = ?, danhmuc = ?, giaban = ?, maton = ?, doituongsudung = ?, hansudung = ?, tinhtrang = ? WHERE mathuoc = ?";
        
        //B3: tạo prepare statement
        try (PreparedStatement pst = sql.prepareStatement(command)) {
            // Gán giá trị cho các tham số
            pst.setString(1, t.getTenthuoc());
            pst.setString(2, advance.StringArrayListToString(t.getDonvi()));
            pst.setString(3, t.getThanhphan());
            pst.setString(4, t.getThongtin());
            pst.setString(5, t.getXuatxu());
            pst.setString(6, t.getDanhmuc());
            pst.setString(7, advance.DoubleArrayListToString(t.getGiaban()));
            pst.setString(8, t.getMaton());
            pst.setString(9, advance.StringArrayListToString(t.getDoituongsudung()));
            pst.setString(10, t.getHansudung());
            pst.setBoolean(11, t.getTinhtrang());
            pst.setString(12, t.getMathuoc());

            // B3: Thực thi câu lệnh
            int ketQua = pst.executeUpdate();

            // B4: Xử lý kết quả
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // B5: Ngắt kết nối
            data.SQL.closeConnection(sql);
        }

        return 0;
    }

    @Override
    public int delete(medicine_DTO t) {
        //B1: kết nối csdl
        Connection sql = data.SQL.createConnection();

        //B2: tạo câu lệnh SQL
        String command = "DELETE FROM Thuoc WHERE mathuoc = ?";
        
        //B3: tạo prepare statement
        try (PreparedStatement pst = sql.prepareStatement(command)) {
            // Gán giá trị cho các tham số
            pst.setString(1, t.getMathuoc());

            // B3: Thực thi câu lệnh
            int ketQua = pst.executeUpdate();

            // B4: Xử lý kết quả
            System.out.println("Xóa thành công " + ketQua + " dòng.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // B5: Ngắt kết nối
            data.SQL.closeConnection(sql);
        }
        return 0;
    }

    @Override
    public ArrayList<medicine_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();
        ArrayList<medicine_DTO> medicines = new ArrayList<>();
        String command = "SELECT * FROM Thuoc";
        
        try (PreparedStatement pst = sql.prepareStatement(command);
        ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                medicine_DTO med = new medicine_DTO();
                med.setMathuoc(rs.getString("mathuoc"));
                med.setTenthuoc(rs.getString("tenthuoc"));
                med.setDonvi(advance.StringconvertToStringArrayList(rs.getString("donvi")));
                med.setThanhphan(rs.getString("thanhphan"));
                med.setThongtin(rs.getString("thongtin"));
                med.setXuatxu(rs.getString("xuatxu"));
                med.setDanhmuc(rs.getString("danhmuc"));
                med.setGiaban(advance.StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(rs.getString("giaban"))));
                med.setMaton(rs.getString("maton"));
                med.setDoituongsudung(advance.StringconvertToStringArrayList(rs.getString("doituongsudung")));
                med.setHansudung(rs.getString("hansudung"));
                med.setTinhtrang(rs.getBoolean("tinhtrang"));
                medicines.add(med);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
        
        return medicines;
    }

    @Override
    public ArrayList<medicine_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();
        ArrayList<medicine_DTO> medicines = new ArrayList<>();
        String command = "SELECT * FROM Thuoc WHERE " + condition;
        
        try (PreparedStatement pst = sql.prepareStatement(command);
            ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                medicine_DTO med = new medicine_DTO();
                med.setMathuoc(rs.getString("mathuoc"));
                med.setTenthuoc(rs.getString("tenthuoc"));
                med.setDonvi(advance.StringconvertToStringArrayList(rs.getString("donvi")));
                med.setThanhphan(rs.getString("thanhphan"));
                med.setThongtin(rs.getString("thongtin"));
                med.setXuatxu(rs.getString("xuatxu"));
                med.setDanhmuc(rs.getString("danhmuc"));
                med.setGiaban(advance.StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(rs.getString("giaban"))));
                med.setMaton(rs.getString("maton"));
                med.setDoituongsudung(advance.StringconvertToStringArrayList(rs.getString("doituongsudung")));
                med.setHansudung(rs.getString("hansudung"));
                med.setTinhtrang(rs.getBoolean("tinhtrang"));
                medicines.add(med);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
        
        return medicines;
    }

    @Override
    public medicine_DTO selectByID(medicine_DTO t) {
        Connection sql = data.SQL.createConnection();
        medicine_DTO med = null;
        String command = "SELECT * FROM Thuoc WHERE mathuoc = ?";
        
        try (PreparedStatement pst = sql.prepareStatement(command)) {
            
            pst.setString(1, t.getMathuoc());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    med = new medicine_DTO();
                    med.setMathuoc(rs.getString("mathuoc"));
                    med.setTenthuoc(rs.getString("tenthuoc"));
                    med.setDonvi(advance.StringconvertToStringArrayList(rs.getString("donvi")));
                    med.setThanhphan(rs.getString("thanhphan"));
                    med.setThongtin(rs.getString("thongtin"));
                    med.setXuatxu(rs.getString("xuatxu"));
                    med.setDanhmuc(rs.getString("danhmuc"));
                    med.setGiaban(advance.StringArrayListToDoubleArrayList(advance.StringconvertToStringArrayList(rs.getString("giaban"))));
                    med.setMaton(rs.getString("maton"));
                    med.setDoituongsudung(advance.StringconvertToStringArrayList(rs.getString("doituongsudung")));
                    med.setHansudung(rs.getString("hansudung"));
                    med.setTinhtrang(rs.getBoolean("tinhtrang"));
                }
                System.out.println("Truy vấn thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }
        
        return med;
    }
}
