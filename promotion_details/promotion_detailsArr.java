package promotion_details;
import java.util.ArrayList;

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
}
