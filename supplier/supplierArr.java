package supplier;
import java.util.ArrayList;

public class supplierArr {
    private ArrayList<supplier> arr;

    public supplierArr() {
        arr = new ArrayList<>();
    }

    public supplierArr(ArrayList<supplier> arr) {
        this.arr = arr;
    }

    public ArrayList<supplier> getArr() {
        return arr;
    }

    public void setArr(ArrayList<supplier> arr) {
        this.arr = arr;
    }
}
