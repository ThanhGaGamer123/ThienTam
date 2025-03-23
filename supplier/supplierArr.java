package supplier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.dataPath;

public class supplierArr {
    private ArrayList<supplier> arr;

    public supplierArr() {
        arr = new ArrayList<>();
    }

    public supplierArr(ArrayList<supplier> arr) {
        this.arr = arr;
    }

    public ArrayList<supplier> getArr() {
        return arr;
    }

    public void setArr(ArrayList<supplier> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.SUPPLIER))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                supplier nv = new supplier(part[0], part[1], part[2], 
                part[3], part[4], part[5], part[6], part[7]);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
