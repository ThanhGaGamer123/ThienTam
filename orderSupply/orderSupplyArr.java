package orderSupply;
import java.util.ArrayList;

public class orderSupplyArr {
    private ArrayList<orderSupply> arr;

    public orderSupplyArr() {
        arr = new ArrayList<>();
    }

    public orderSupplyArr(ArrayList<orderSupply> arr) {
        this.arr = arr;
    }

    public ArrayList<orderSupply> getArr() {
        return arr;
    }

    public void setArr(ArrayList<orderSupply> arr) {
        this.arr = arr;
    }
}
