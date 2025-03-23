package medicine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import advanceMethod.advance;
import data.dataPath;

public class medicineArr {
    private ArrayList<medicine> arr;

    public medicineArr() {
        arr = new ArrayList<>();
    }

    public medicineArr(ArrayList<medicine> arr) {
        this.arr = arr;
    }

    public ArrayList<medicine> getArr() {
        return arr;
    }

    public void setArr(ArrayList<medicine> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.MEDICINE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                String[] donvi = part[4].split(";");
                String[] thanhphan = part[5].split(";");
                String[] gianhap = part[8].split(";");
                int[] int_gianhap = advance.convertToIntArray(gianhap);
                String[] giaban = part[9].split(";");
                int[] int_giaban = advance.convertToIntArray(giaban);
                medicine nv = new medicine(part[0], part[1], part[2], 
                part[3], donvi, thanhphan, part[6], part[7], int_gianhap, int_giaban);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
