package bai1_2;

import java.util.concurrent.BlockingQueue;

public class Counter implements Runnable {
    private final BlockingQueue<Storage> queue;

    public Counter(BlockingQueue<Storage> blockingQueue) {
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                queue.put(new Storage(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
