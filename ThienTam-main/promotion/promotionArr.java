package promotion;
import java.util.ArrayList;

public class promotionArr {
    private ArrayList<promotion> arr;

    public promotionArr() {
        arr = new ArrayList<>();
    }

    public promotionArr(ArrayList<promotion> arr) {
        this.arr = arr;
    }

    public ArrayList<promotion> getArr() {
        return arr;
    }

    public void setArr(ArrayList<promotion> arr) {
        this.arr = arr;
    }
}
