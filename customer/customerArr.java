package customer;
import java.util.ArrayList;

public class customerArr {
    private ArrayList<customer> arr;

    public customerArr() {
        arr = new ArrayList<>();
    }

    public customerArr(ArrayList<customer> arr) {
        this.arr = arr;
    }

    public ArrayList<customer> getArr() {
        return arr;
    }

    public void setArr(ArrayList<customer> arr) {
        this.arr = arr;
    }
}
