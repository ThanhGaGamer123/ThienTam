package customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class customerArr {
    private ArrayList<customer> a;

    public customerArr() {
    }

    public customerArr(ArrayList<customer> a) {
        this.a = a;
    }

    public ArrayList<customer> getA() {
        return a;
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("D:\\DownLoads\\ThienTam-main\\ThienTam-main\\data\\customer.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                customer kh = new customer(part[0], part[1], Integer.parseInt(part[2]),
                        part[3], part[4], part[5], part[6], part[7],
                        Integer.parseInt(part[8]), part[9]);
                a.add(kh);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
