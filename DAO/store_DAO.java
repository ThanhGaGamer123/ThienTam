package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.store_DTO;

public class store_DAO implements DAO<store_DTO> {
    @Override
    public int add(store_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO NhaThuoc (mant, masonha, duong, phuong, quan, tinh, manql, tinhtrang)" + 
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMant());
            pst.setString(2, t.getMasonha());
            pst.setString(3, t.getDuong());
            pst.setString(4, t.getPhuong());
            pst.setString(5, t.getQuan());
            pst.setString(6, t.getTinh());
            pst.setString(7, t.getManql());
            pst.setBoolean(8, t.getTinhtrang());

            int ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return 0;
    }
    
    @Override
    public int update(store_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE NhaThuoc SET masonha = ?, duong = ?, phuong = ?, quan = ?, tinh = ?, manql = ?, tinhtrang = ? WHERE mant = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMasonha());
            pst.setString(2, t.getDuong());
            pst.setString(3, t.getPhuong());
            pst.setString(4, t.getQuan());
            pst.setString(5, t.getTinh());
            pst.setString(6, t.getManql());
            pst.setBoolean(7, t.getTinhtrang());
            pst.setString(8, t.getMant());

            int ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return 0;
    }

    public int update1(store_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE NhaThuoc SET masonha = ?, duong = ?, phuong = ?, quan = ?, tinh = ?, manql = ?, tinhtrang = ? WHERE mant = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMasonha());
            pst.setString(2, t.getDuong());
            pst.setString(3, t.getPhuong());
            pst.setString(4, t.getQuan());
            pst.setString(5, t.getTinh());
            pst.setString(6, t.getManql());
            pst.setBoolean(7, false);
            pst.setString(8, t.getMant());

            int ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return 0;
    }

    public String autoUpdateMaNT() {
        String maNT = null;
        Connection con = data.SQL.createConnection();
        try (PreparedStatement ps = con.prepareStatement("select top 1 mant from NhaThuoc order by mant desc")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maNT = rs.getString("mant");
                int newMaNT = Integer.parseInt(maNT.substring(2)) + 1;
                maNT = String.format("NT%04d", newMaNT);
            } else {
                maNT = "NT0001";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(con);
        }
        return maNT;
    }

    @Override
    public int delete(store_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM NhaThuoc WHERE mant = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMant());

            int ketQua = pst.executeUpdate();
            System.out.println("Bạn đã thực thi: " + command);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return 0;
    }

    @Override
    public ArrayList<store_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<store_DTO> stores = new ArrayList<>();
        String command = "SELECT * FROM NhaThuoc";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                store_DTO str = new store_DTO();
                str.setMant(rs.getString("mant"));
                str.setMasonha(rs.getString("masonha"));
                str.setDuong(rs.getString("duong"));
                str.setPhuong(rs.getString("phuong"));
                str.setQuan(rs.getString("quan"));
                str.setTinh(rs.getString("tinh"));
                str.setManql(rs.getString("manql"));
                str.setTinhtrang(rs.getBoolean("tinhtrang"));
                stores.add(str);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return stores;
    }

    @Override
    public ArrayList<store_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<store_DTO> stores = new ArrayList<>();
        String command = "SELECT * FROM NhaThuoc WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                store_DTO str = new store_DTO();
                str.setMant(rs.getString("mant"));
                str.setMasonha(rs.getString("masonha"));
                str.setDuong(rs.getString("duong"));
                str.setPhuong(rs.getString("phuong"));
                str.setQuan(rs.getString("quan"));
                str.setTinh(rs.getString("tinh"));
                str.setManql(rs.getString("manql"));
                str.setTinhtrang(rs.getBoolean("tinhtrang"));
                stores.add(str);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return stores;
    }

    @Override
    public store_DTO selectByID(store_DTO t) {
        Connection sql = data.SQL.createConnection();

        store_DTO str = new store_DTO();
        String command = "SELECT * FROM NhaThuoc WHERE mant = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMant());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                str.setMant(rs.getString("mant"));
                str.setMasonha(rs.getString("masonha"));
                str.setDuong(rs.getString("duong"));
                str.setPhuong(rs.getString("phuong"));
                str.setQuan(rs.getString("quan"));
                str.setTinh(rs.getString("tinh"));
                str.setManql(rs.getString("manql"));
                str.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return str;
    }
}
