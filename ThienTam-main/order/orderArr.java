package order;
import java.util.ArrayList;

public class orderArr {
    ArrayList<order> arr;

    public orderArr() {
        arr = new ArrayList<>();
    }

    public orderArr(ArrayList<order> arr) {
        this.arr = arr;
    }

    public ArrayList<order> getArr() {
        return arr;
    }

    public void setArr(ArrayList<order> arr) {
        this.arr = arr;
    }
}
