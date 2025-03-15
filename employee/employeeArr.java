package employee;

import data.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class employeeArr {
    private ArrayList<employee> arr;

    public employeeArr() {
        arr = new ArrayList<>();
    }

    public employeeArr(ArrayList<employee> arr) {
        this.arr = arr;
    }

    public ArrayList<employee> getArr() {
        return arr;
    }

    public void setArr(ArrayList<employee> arr) {
        this.arr = arr;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath.EMPLOYEE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(", ");
                employee nv = new employee(part[0], part[1], part[2], 
                part[3], part[4], part[5], part[6], part[7],
                part[8], part[9], part[10], part[11]);
                arr.add(nv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

