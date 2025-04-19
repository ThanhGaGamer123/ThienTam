package BUS;

import javax.swing.JLabel;

import DTO.store_DTO;

public class store_BUS {
    public static void loadData(store_DTO nt ,JLabel mant, JLabel manql, JLabel diachi, JLabel tinhtrang) {
        mant.setText(mant.getText() + nt.getMant());
        diachi.setText(diachi.getText() + nt.getMasonha() + ", " + nt.getDuong() + ", " + nt.getPhuong() + ", " + nt.getQuan() + ", " + nt.getTinh());
        manql.setText(manql.getText() + nt.getManql());
        if(nt.getTinhtrang()) tinhtrang.setText(tinhtrang.getText() + "Đang hoạt động");
        else tinhtrang.setText(tinhtrang.getText() + "Ngừng hoạt động");
    }
}
