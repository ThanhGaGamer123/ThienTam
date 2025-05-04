package Arr_xt;

import DTO.order_DTO;
import java.util.ArrayList;

public class orderArr {
    ArrayList<order_DTO> arr;

    public orderArr() {
        arr = new ArrayList<>();
    }

    public orderArr(ArrayList<order_DTO> arr) {
        this.arr = arr;
    }

    public ArrayList<order_DTO> getArr() {
        return arr;
    }

    public void setArr(ArrayList<order_DTO> arr) {
        this.arr = arr;
    }
}
