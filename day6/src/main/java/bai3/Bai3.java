package bai3;

import java.util.concurrent.ExecutionException;

public class Bai3{
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        Integer[] a = new Integer[0];
        try {
            a = new CountDivisorsWithThreads().countDivisors();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a0 = " + a[0]);
        System.out.println("a1 = " + a[1]);
        System.out.println((System.currentTimeMillis() - time1)/1000.);

//        long time2 = System.currentTimeMillis();
//        Integer[] ar = new CountDivisorsWithThreads.CountDivisorsWithThread(0, 100000).call();
//        System.out.println(ar[0]);
//        System.out.println(ar[1]);
//        System.out.println((System.currentTimeMillis()-time2)/1000.);


//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
