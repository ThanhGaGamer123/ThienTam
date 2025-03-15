package store;

import data.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class storeArr {
    private ArrayList<store> arr;

    public storeArr() {
        arr = new ArrayList<>();
    }

    public storeArr(ArrayList<store> arr) {
        this.arr = arr;
    }

    public ArrayList<store> getArr() {
        return arr;
    }

    public void setArr(ArrayList<store> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.STORE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                store nt = new store(part[0], part[1], part[2], 
                part[3], part[4], part[5], part[6]);
                arr.add(nt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
