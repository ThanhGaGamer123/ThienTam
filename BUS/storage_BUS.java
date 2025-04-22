package BUS;

import java.util.ArrayList;

import DAO.medicine_DAO;
import DAO.storage_DAO;
import DTO.medicine_DTO;
import DTO.orderSupply_details_DTO;
import DTO.storage_DTO;
import advanceMethod.advance;

public class storage_BUS {
    //tạo tổn kho mới
    public static void createStock(medicine_DTO med) {
        storage_DAO strDAO = new storage_DAO();
        ArrayList<storage_DTO> temp_2 = strDAO.selectAll();
        storage_DTO str = new storage_DTO();
        med.setMaton("MTO"+advance.calculateID(temp_2.size()));
        str.setMaton(med.getMaton());

        ArrayList<Integer> slton = new ArrayList<>();
        slton.add(0);
        slton.add(0);
        slton.add(0);
        str.setSlton(slton);

        str.setTinhtrang(true);

        strDAO.add(str);
    }

    //cập nhật số lượng tồn khi nhập hàng
    public static void increaseStock(ArrayList<orderSupply_details_DTO> osds) {
        for (orderSupply_details_DTO osd : osds) {
            medicine_DTO medicine = new medicine_DTO();
            medicine.setMathuoc(osd.getMathuoc());
            medicine_DAO medicineDAO = new medicine_DAO();
            medicine = medicineDAO.selectByID(medicine);

            storage_DTO storage = new storage_DTO();
            storage.setMaton(medicine.getMaton());
            storage_DAO storageDAO = new storage_DAO();
            storage = storageDAO.selectByID(storage);

            for (int i = 0; i < 3; i++) {
                storage.getSlton().set(i, storage.getSlton().get(i) + osd.getSlnhap().get(i));
            }

            storageDAO.update(storage);
        }
    }

    //cập nhật số lượng tồn khi thu hồi nhiều ct
    public static void decreaseStock(ArrayList<orderSupply_details_DTO> osds) {
        for (orderSupply_details_DTO osd : osds) {
            medicine_DTO medicine = new medicine_DTO();
            medicine.setMathuoc(osd.getMathuoc());
            medicine_DAO medicineDAO = new medicine_DAO();
            medicine = medicineDAO.selectByID(medicine);

            storage_DTO storage = new storage_DTO();
            storage.setMaton(medicine.getMaton());
            storage_DAO storageDAO = new storage_DAO();
            storage = storageDAO.selectByID(storage);

            for (int i = 0; i < 3; i++) {
                storage.getSlton().set(i, storage.getSlton().get(i) - osd.getSlcon().get(i));
            }

            storageDAO.update(storage);
        }
    }

    //cập nhật số lượng tồn khi thu hồi 1 ct
    public static void decreaseStock(orderSupply_details_DTO osd) {
        medicine_DTO medicine = new medicine_DTO();
        medicine.setMathuoc(osd.getMathuoc());
        medicine_DAO medicineDAO = new medicine_DAO();
        medicine = medicineDAO.selectByID(medicine);

        storage_DTO storage = new storage_DTO();
        storage.setMaton(medicine.getMaton());
        storage_DAO storageDAO = new storage_DAO();
        storage = storageDAO.selectByID(storage);

        for (int i = 0; i < 3; i++) {
            storage.getSlton().set(i, storage.getSlton().get(i) - osd.getSlcon().get(i));
        }

        storageDAO.update(storage);
    }
    
    //xóa tồn kho
    public static void deleteStock(medicine_DTO med) {
        storage_DTO str = medicine_BUS.throwStorageObj(med.getMaton());
        str.setTinhtrang(false);
        storage_DAO strDAO = new storage_DAO();
        strDAO.update(str);
    }
}
