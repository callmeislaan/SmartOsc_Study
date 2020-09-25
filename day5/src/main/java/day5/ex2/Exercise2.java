package day5.ex2;

public class Exercise2 <T>{
    public void exchange(T[] t, int index1, int index2) {
        T temp = t[index1];
        t[index1] = t[index2];
        t[index2] = temp;
    }
}