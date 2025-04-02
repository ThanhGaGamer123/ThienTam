package orderSupply_details;
import java.util.ArrayList;

public class orderSupply_detailsArr {
    private ArrayList<orderSupply_details> arr;

    public orderSupply_detailsArr() {
        arr = new ArrayList<>();
    }

    public orderSupply_detailsArr(ArrayList<orderSupply_details> arr) {
        this.arr = arr;
    }

    public ArrayList<orderSupply_details> getArr() {
        return arr;
    }

    public void setArr(ArrayList<orderSupply_details> arr) {
        this.arr = arr;
    }
}
