package orderSupply;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.dataPath;

public class orderSupplyArr {
    private ArrayList<orderSupply> arr;

    public orderSupplyArr() {
        arr = new ArrayList<>();
    }

    public orderSupplyArr(ArrayList<orderSupply> arr) {
        this.arr = arr;
    }

    public ArrayList<orderSupply> getArr() {
        return arr;
    }

    public void setArr(ArrayList<orderSupply> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.ORDER_SUPPLY))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                orderSupply nv = new orderSupply(part[0], part[1], part[2], 
                part[3], part[4]);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
