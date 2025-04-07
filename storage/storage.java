package storage;

import java.util.ArrayList;

public class storage {
    private String maton;
    private ArrayList<Integer> slton;

    private Boolean tinhtrang;
    
    public storage() {
    }

    public storage(String maton, ArrayList<Integer> slton, Boolean tinhtrang) {
        this.maton = maton;
        this.slton = slton;
        this.tinhtrang = tinhtrang;
    }

    public String getMaton() {
        return maton;
    }

    public void setMaton(String maton) {
        this.maton = maton;
    }

    public ArrayList<Integer> getSlton() {
        return slton;
    }

    public void setSlton(ArrayList<Integer> slton) {
        this.slton = slton;
    }

    public Boolean getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(Boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
