package employee;
import java.util.ArrayList;

public class employeeArr {
    private ArrayList<employee> arr;

    public employeeArr() {
        arr = new ArrayList<>();
    }

    public employeeArr(ArrayList<employee> arr) {
        this.arr = arr;
    }

    public ArrayList<employee> getArr() {
        return arr;
    }

    public void setArr(ArrayList<employee> arr) {
        this.arr = arr;
    }
}

