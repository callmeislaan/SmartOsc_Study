package bai3;

import sun.tools.jar.resources.jar;

import javax.management.monitor.Monitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CountDivisorsWithThreads {

    private int max1 = 0;
    private int max2 = 0;

    public Integer[] getMax(Integer[] integers) {
        return integers[1] > this.max2 ? integers : new Integer[]{this.max1, this.max2};
    }

    public Integer[] countDivisors() throws ExecutionException, InterruptedException {
        int max1 = 0, max2 = 0;

        // use future and callable
//        Callable[] callable = new CountDivisorsWithThread[10];
//        List<Future> futures = new ArrayList<>();
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 10; i++) {
//            callable[i] = new CountDivisorsWithThread(i * 10000, (i + 1) * 10000);
//            futures.add(service.submit(callable[i]));
//        }
//        service.shutdown();

//        for (int i = 0; i < 10; i++) {
//            try {
//                Integer[] integers = (Integer[]) futures.get(i).get();
//                if (integers[1] > max2) {
//                    max1 = integers[0];
//                    max2 = integers[1];
//                }
////            System.out.println(integers[0] + " " + integers[1]);
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }


        // use completableFuture

        ExecutorService service = Executors.newFixedThreadPool(10);
        CompletableFuture[] futures = new CompletableFuture[10];
        for (int i = 0; i < 10; i++) {
            int start = i*10000;
            int end = (i+1)*10000;
            futures[i] = CompletableFuture
                    .supplyAsync(() -> new CountDivisorsWithThread(start, end).call(), service)
                    .thenApply(this::getMax);
        }

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futures);



        service.shutdown();
//        return result.get();
        return new Integer[2];
    }

    static class CountDivisorsWithThread implements Callable<Integer[]> {
        private final int start;
        private final int end;

        public CountDivisorsWithThread(int start, int end) {
            System.out.println(start);
            this.start = start;
            this.end = end;
        }

        public boolean isDivisor(int n, int number) {
            if (number == 0) return false;
            return n % number == 0;
        }

        public int countDivisors(int number) {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (isDivisor(number, i))
                    count++;
            }
            return count;
        }

        @Override
        public Integer[] call() {
            int amountOfDivisor = 0;
            int max = 0;
            int maxIndex = 0;
            for (int i = this.start; i < this.end; i++) {
                amountOfDivisor = countDivisors(i);
                if (max < amountOfDivisor) {
                    max = amountOfDivisor;
                    maxIndex = i;
                }
            }
            System.out.println(end);
            return new Integer[]{maxIndex, max};
        }
    }

}
