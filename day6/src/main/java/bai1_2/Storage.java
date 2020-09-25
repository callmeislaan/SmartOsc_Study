package bai1_2;

public class Storage{
    private  int number;

    public Storage(int number) {
        this.number = number;
    }

    public synchronized int getNumber() {
        return number;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }
}
