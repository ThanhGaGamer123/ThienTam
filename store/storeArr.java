package store;
import java.util.ArrayList;

public class storeArr {
    private ArrayList<store> arr;

    public storeArr() {
        arr = new ArrayList<>();
    }

    public storeArr(ArrayList<store> arr) {
        this.arr = arr;
    }

    public ArrayList<store> getArr() {
        return arr;
    }

    public void setArr(ArrayList<store> arr) {
        this.arr = arr;
    }
}
