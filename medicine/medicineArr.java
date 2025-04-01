package medicine;
import java.util.ArrayList;

public class medicineArr {
    private ArrayList<medicine> arr;

    public medicineArr() {
        arr = new ArrayList<>();
    }

    public medicineArr(ArrayList<medicine> arr) {
        this.arr = arr;
    }

    public ArrayList<medicine> getArr() {
        return arr;
    }

    public void setArr(ArrayList<medicine> arr) {
        this.arr = arr;
    }
}
