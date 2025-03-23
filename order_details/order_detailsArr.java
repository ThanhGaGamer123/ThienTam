package order_details;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.dataPath;

public class order_detailsArr {
    private ArrayList<order_details> arr;

    public order_detailsArr() {
        arr = new ArrayList<>();
    }

    public order_detailsArr(ArrayList<order_details> arr) {
        this.arr = arr;
    }

    public ArrayList<order_details> getArr() {
        return arr;
    }

    public void setArr(ArrayList<order_details> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.ORDER_DETAILS))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                order_details nv = new order_details(part[0], part[1], part[2], 
                Integer.parseInt(part[3]), Integer.parseInt(part[4]), Integer.parseInt(part[5]));
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
