package order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.dataPath;

public class orderArr {
    ArrayList<order> arr;

    public orderArr() {
        arr = new ArrayList<>();
    }

    public orderArr(ArrayList<order> arr) {
        this.arr = arr;
    }

    public ArrayList<order> getArr() {
        return arr;
    }

    public void setArr(ArrayList<order> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.ORDER))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                order dh = new order(part[0], part[1], part[2], 
                part[3], part[4], part[5], part[6], part[7],
                part[8], part[9], part[10], part[11]);
                arr.add(dh);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
