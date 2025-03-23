package storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import advanceMethod.advance;
import data.dataPath;
import employee.employee;

public class storageArr {
    private ArrayList<storage> arr;

    public storageArr() {
        arr = new ArrayList<>();
    }

    public storageArr(ArrayList<storage> arr) {
        this.arr = arr;
    }

    public ArrayList<storage> getArr() {
        return arr;
    }

    public void setArr(ArrayList<storage> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.STORAGE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                String[] slton = part[1].split(";");
                int[] int_slton = advance.convertToIntArray(slton);
                storage nv = new storage(part[0], int_slton);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
