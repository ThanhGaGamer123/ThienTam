package cart;

import java.util.ArrayList;
import java.util.List;

public class cart {
    private List<String> items;


    public cart() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}