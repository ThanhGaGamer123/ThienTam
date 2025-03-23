package promotion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.dataPath;

public class promotionArr {
    private ArrayList<promotion> arr;

    public promotionArr() {
        arr = new ArrayList<>();
    }

    public promotionArr(ArrayList<promotion> arr) {
        this.arr = arr;
    }

    public ArrayList<promotion> getArr() {
        return arr;
    }

    public void setArr(ArrayList<promotion> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.PROMOTION))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                promotion nv = new promotion(part[0], part[1], part[2], part[3], part[4]);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
