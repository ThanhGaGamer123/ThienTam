package storage;
import java.util.ArrayList;

public class storageArr {
    private ArrayList<storage> arr;

    public storageArr() {
        arr = new ArrayList<>();
    }

    public storageArr(ArrayList<storage> arr) {
        this.arr = arr;
    }

    public ArrayList<storage> getArr() {
        return arr;
    }

    public void setArr(ArrayList<storage> arr) {
        this.arr = arr;
    }
}
