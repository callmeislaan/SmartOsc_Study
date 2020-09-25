package bai1_2;

import java.util.concurrent.BlockingQueue;

public class Printer implements Runnable {
    private final BlockingQueue<Storage> blockingQueue;

    public Printer(BlockingQueue<Storage> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(blockingQueue.take().getNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
