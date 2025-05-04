package data.Arr_xt;

import DTO.order_details_DTO;
import java.util.ArrayList;

public class order_detailsArr {
    private ArrayList<order_details_DTO> arr;

    public order_detailsArr() {
        arr = new ArrayList<>();
    }

    public order_detailsArr(ArrayList<order_details_DTO> arr) {
        this.arr = arr;
    }

    public ArrayList<order_details_DTO> getArr() {
        return arr;
    }

    public void setArr(ArrayList<order_details_DTO> arr) {
        this.arr = arr;
    }
}
