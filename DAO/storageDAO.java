package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.storage_DTO;
import advanceMethod.advance;

public class storageDAO implements DAO<storage_DTO> {
    @Override
    public int add(storage_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "INSERT INTO Kho (maton, slton, tinhtrang)" + "VALUES (?, ?, ?)";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMaton());
            pst.setString(2, advance.IntArrayListToString(t.getSlton()));
            pst.setBoolean(3, t.getTinhtrang());

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
    public int update(storage_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "UPDATE Kho SET slton = ?, tinhtrang = ? WHERE maton = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, advance.IntArrayListToString(t.getSlton()));
            pst.setBoolean(2, t.getTinhtrang());
            pst.setString(3, t.getMaton());

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
    public int delete(storage_DTO t) {
        Connection sql = data.SQL.createConnection();

        String command = "DELETE FROM Kho WHERE maton = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMaton());

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
    public ArrayList<storage_DTO> selectAll() {
        Connection sql = data.SQL.createConnection();

        ArrayList<storage_DTO> storages = new ArrayList<>();
        String command = "SELECT * FROM Kho";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                storage_DTO st = new storage_DTO();
                st.setMaton(rs.getString("maton"));
                st.setSlton(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slton"))));
                st.setTinhtrang(rs.getBoolean("tinhtrang"));
                storages.add(st);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return storages;
    }

    @Override
    public ArrayList<storage_DTO> selectByCondition(String condition) {
        Connection sql = data.SQL.createConnection();

        ArrayList<storage_DTO> storages = new ArrayList<>();
        String command = "SELECT * FROM Kho WHERE " + condition;

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                storage_DTO st = new storage_DTO();
                st.setMaton(rs.getString("maton"));
                st.setSlton(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slton"))));
                st.setTinhtrang(rs.getBoolean("tinhtrang"));
                storages.add(st);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return storages;
    }

    @Override
    public storage_DTO selectByID(storage_DTO t) {
        Connection sql = data.SQL.createConnection();

        storage_DTO st = new storage_DTO();
        String command = "SELECT * FROM Kho WHERE maton = ?";

        try (PreparedStatement pst = sql.prepareStatement(command)) {
            pst.setString(1, t.getMaton());

            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                st.setMaton(rs.getString("maton"));
                st.setSlton(advance.StringArrayListToIntArrayList(advance.StringconvertToStringArrayList(rs.getString("slton"))));
                st.setTinhtrang(rs.getBoolean("tinhtrang"));
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data.SQL.closeConnection(sql);
        }

        return st;
    }    
}
