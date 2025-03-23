package storage;

public class storage {
    private String maton;
    private int slton;
    
    public storage() {
    }

    public storage(String maton, int slton) {
        this.maton = maton;
        this.slton = slton;
    }

    public String getMaton() {
        return maton;
    }

    public void setMaton(String maton) {
        this.maton = maton;
    }

    public int getSlton() {
        return slton;
    }

    public void setSlton(int slton) {
        this.slton = slton;
    }
}
