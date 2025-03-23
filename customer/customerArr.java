package customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.dataPath;

public class customerArr {
    private ArrayList<customer> arr;

    public customerArr() {
        arr = new ArrayList<>();
    }

    public customerArr(ArrayList<customer> arr) {
        this.arr = arr;
    }

    public ArrayList<customer> getArr() {
        return arr;
    }

    public void setArr(ArrayList<customer> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.CUSTOMER))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                customer nv = new customer(part[0], part[1], Integer.parseInt(part[2]), 
                part[3], part[4], part[5], part[6], part[7],
                part[8], part[9]);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
