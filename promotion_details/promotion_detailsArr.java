package promotion_details;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.dataPath;

public class promotion_detailsArr {
    private ArrayList<promotion_details> arr;

    public promotion_detailsArr() {
        arr = new ArrayList<>();
    }

    public promotion_detailsArr(ArrayList<promotion_details> arr) {
        this.arr = arr;
    }

    public ArrayList<promotion_details> getArr() {
        return arr;
    }

    public void setArr(ArrayList<promotion_details> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.PROMOTION_DETAILS))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                promotion_details nv = new promotion_details(part[0], part[1], part[2], 
                part[3], part[4], part[5]);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
