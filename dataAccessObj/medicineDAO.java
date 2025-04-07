package dataAccessObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import advanceMethod.advance;
import medicine.medicine;

public class medicineDAO implements DAO<medicine> {
    @Override
    public int add(medicine t) {
        //B1: kết nối csdl
        Connection sql = data.SQL.createConnection();

        //B2: tạo câu lệnh SQL
        String command = "INSERT INTO Thuoc (mathuoc, tenthuoc, donvi, thanhphan, thongtin, xuatxu, danhmuc, giaban, maton, doituongsudung, tinhtrang) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
            pst.setString(8, advance.IntArrayListToString(t.getGiaban()));
            pst.setString(9, t.getMaton());
            pst.setString(10, advance.StringArrayListToString(t.getDoituongsudung()));
            pst.setBoolean(11, t.getTinhtrang());

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
    public int update(medicine t) {
        //B1: kết nối csdl
        Connection sql = data.SQL.createConnection();

        //B2: tạo câu lệnh SQL
        String command = "UPDATE Thuoc SET tenthuoc = ?, donvi = ?, thanhphan = ?, thongtin = ?, xuatxu = ?, danhmuc = ?, giaban = ?, maton = ?, doituongsudung = ?, tinhtrang = ? WHERE mathuoc = ?";
        
        //B3: tạo prepare statement
        try (PreparedStatement pst = sql.prepareStatement(command)) {
            // Gán giá trị cho các tham số
            pst.setString(1, t.getTenthuoc());
            pst.setString(2, advance.StringArrayListToString(t.getDonvi()));
            pst.setString(3, t.getThanhphan());
            pst.setString(4, t.getThongtin());
            pst.setString(5, t.getXuatxu());
            pst.setString(6, t.getDanhmuc());
            pst.setString(7, advance.IntArrayListToString(t.getGiaban()));
            pst.setString(8, t.getMaton());
            pst.setString(9, advance.StringArrayListToString(t.getDoituongsudung()));
            pst.setString(10, t.getMathuoc());
            pst.setBoolean(11, t.getTinhtrang());

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
    public int delete(medicine t) {
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
    public ArrayList<medicine> selectAll() {
        ArrayList<medicine> medicines = new ArrayList<>();
        String command = "SELECT * FROM Thuoc";
        
        try (Connection sql = data.SQL.createConnection();
        PreparedStatement pst = sql.prepareStatement(command);
        ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                medicine med = new medicine();
                med.setMathuoc(rs.getString("mathuoc"));
                med.setTenthuoc(rs.getString("tenthuoc"));
                med.setDonvi(advance.StringconvertToStringArrayList(rs.getString("donvi")));
                med.setThanhphan(rs.getString("thanhphan"));
                med.setThongtin(rs.getString("thongtin"));
                med.setXuatxu(rs.getString("xuatxu"));
                med.setDanhmuc(rs.getString("danhmuc"));
                med.setGiaban(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("giaban"))));
                med.setMaton(rs.getString("maton"));
                med.setDoituongsudung(advance.StringconvertToStringArrayList(rs.getString("doituongsudung")));
                med.setTinhtrang(rs.getBoolean("tinhtrang"));
                medicines.add(med);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return medicines;
    }

    @Override
    public ArrayList<medicine> selectByCondition(String condition) {
        ArrayList<medicine> medicines = new ArrayList<>();
        String command = "SELECT * FROM Thuoc WHERE " + condition;
        
        try (Connection sql = data.SQL.createConnection();
            PreparedStatement pst = sql.prepareStatement(command);
            ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                medicine med = new medicine();
                med.setMathuoc(rs.getString("mathuoc"));
                med.setTenthuoc(rs.getString("tenthuoc"));
                med.setDonvi(advance.StringconvertToStringArrayList(rs.getString("donvi")));
                med.setThanhphan(rs.getString("thanhphan"));
                med.setThongtin(rs.getString("thongtin"));
                med.setXuatxu(rs.getString("xuatxu"));
                med.setDanhmuc(rs.getString("danhmuc"));
                med.setGiaban(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("giaban"))));
                med.setMaton(rs.getString("maton"));
                med.setDoituongsudung(advance.StringconvertToStringArrayList(rs.getString("doituongsudung")));
                med.setTinhtrang(rs.getBoolean("tinhtrang"));
                medicines.add(med);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return medicines;
    }

    @Override
    public medicine selectByID(medicine t) {
        medicine med = null;
        String command = "SELECT * FROM Thuoc WHERE mathuoc = ?";
        
        try (Connection sql = data.SQL.createConnection();
            PreparedStatement pst = sql.prepareStatement(command)) {
            
            pst.setString(1, t.getMathuoc());
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    med = new medicine();
                    med.setMathuoc(rs.getString("mathuoc"));
                    med.setTenthuoc(rs.getString("tenthuoc"));
                    med.setDonvi(advance.StringconvertToStringArrayList(rs.getString("donvi")));
                    med.setThanhphan(rs.getString("thanhphan"));
                    med.setThongtin(rs.getString("thongtin"));
                    med.setXuatxu(rs.getString("xuatxu"));
                    med.setDanhmuc(rs.getString("danhmuc"));
                    med.setGiaban(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("giaban"))));
                    med.setMaton(rs.getString("maton"));
                    med.setDoituongsudung(advance.StringconvertToStringArrayList(rs.getString("doituongsudung")));
                    med.setTinhtrang(rs.getBoolean("tinhtrang"));
                }
                System.out.println("Truy vấn thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return med;
    }
}
