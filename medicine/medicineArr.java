package medicine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
                medicine nv = new medicine(part[0], part[1], part[2], 
                part[3], part[4], part[5], part[6], part[7], part[8]);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
