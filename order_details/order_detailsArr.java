package order_details;
import java.util.ArrayList;

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
}
