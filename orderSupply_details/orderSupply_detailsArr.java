package orderSupply_details;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import advanceMethod.advance;
import data.dataPath;

public class orderSupply_detailsArr {
    private ArrayList<orderSupply_details> arr;

    public orderSupply_detailsArr() {
        arr = new ArrayList<>();
    }

    public orderSupply_detailsArr(ArrayList<orderSupply_details> arr) {
        this.arr = arr;
    }

    public ArrayList<orderSupply_details> getArr() {
        return arr;
    }

    public void setArr(ArrayList<orderSupply_details> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.ORDER_SUPPLY_DETAILS))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                String[] slnhap = part[3].split(";");
                int[] int_slnhap = advance.convertToIntArray(slnhap);
                String[] dongia = part[4].split(";");
                int[] int_dongia = advance.convertToIntArray(dongia);
                orderSupply_details nv = new orderSupply_details(part[0], part[1], part[2], 
                int_slnhap, int_dongia, Integer.parseInt(part[5]));
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
