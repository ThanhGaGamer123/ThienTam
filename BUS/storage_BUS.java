package BUS;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAO.medicine_DAO;
import DAO.orderSupply_details_DAO;
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

    //load lại số lượng tồn của thuốc
    public static void loadQuantity(orderSupply_details_DTO osd) {
        medicine_DTO med = new medicine_DTO();
        med.setMathuoc(osd.getMathuoc());
        medicine_DAO medDAO = new medicine_DAO();
        med = medDAO.selectByID(med);

        storage_DTO str = new storage_DTO();
        str.setMaton(med.getMaton());
        storage_DAO strDAO = new storage_DAO();
        str = strDAO.selectByID(str);

        ArrayList<orderSupply_details_DTO> osds = new ArrayList<>();
        orderSupply_details_DAO osdDAO = new orderSupply_details_DAO();
        osds = osdDAO.selectAll();

        str.getSlton().set(0, 0);
        str.getSlton().set(1, 0);
        str.getSlton().set(2, 0);

        for (orderSupply_details_DTO osD : osds) {
            if(osD.getTinhtrang() && osD.getMathuoc().equals(osd.getMathuoc())) {
                for (int i = 0; i < 3; i++) {
                    str.getSlton().set(i, str.getSlton().get(i) + osD.getSlcon().get(i));
                }
            }
        }

        strDAO.update(str);
    }

    public static void autoLoadQuantity() {
        ArrayList<storage_DTO> strS = new ArrayList<>();
        storage_DAO strDAO = new storage_DAO();
        strS = strDAO.selectAll();
        for (storage_DTO str : strS) {
            ArrayList<Integer> sl = new ArrayList<>();
            sl.add(0);
            sl.add(0);
            sl.add(0);
            str.setSlton(sl);
            strDAO.update(str);
        }
        
        ArrayList<orderSupply_details_DTO> osds = new orderSupply_details_DAO().selectAll();
        for (orderSupply_details_DTO osd : osds) {
            loadQuantity(osd);
        }
    }

    //Tuấn
    public static void loadDataTable(DefaultTableModel table) {
        storage_DAO dao = new storage_DAO();
        medicine_DAO meddao = new medicine_DAO();
        ArrayList<storage_DTO> storagelist = new ArrayList<>();
        ArrayList<medicine_DTO> medlist = new ArrayList<>();
        storagelist = dao.selectAll();
        medlist = meddao.selectAll();
        for (storage_DTO sto : storagelist) {
            ArrayList<Integer> sl = sto.getSlton();
            String tenSP = null;
            for (medicine_DTO med : medlist) {
                if (med.getMaton().equals(sto.getMaton())) {
                    tenSP = med.getTenthuoc();
                }
            }
            table.addRow(new Object[] { sto.getMaton(), tenSP, sl.get(0), sl.get(1), sl.get(2) });
        }
    }
}
