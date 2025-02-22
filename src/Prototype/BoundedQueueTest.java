package Prototype;

import java.util.Random;
import java.util.concurrent.Semaphore;

 class BoundedQueue {
    private int[] queue;
    private Semaphore empty;
    private Semaphore full;
    private int rear = 0, front = 0;
    
    public BoundedQueue(int capacity) {
        queue = new int[capacity];
        empty = new Semaphore(capacity);
        full = new Semaphore(0);
    }
    public void enque(int item) throws InterruptedException {
        empty.acquire();
        synchronized (this) {
            queue[rear] = item;
            rear = (rear + 1) % queue.length;
        }
        full.release();
    }

    public int deque() throws InterruptedException {
        full.acquire();
        int item;
        synchronized (this) {
            item = queue[front];
            front = (front + 1) % queue.length;
        }
        empty.release();
        return item;
    }
}

public class BoundedQueueTest {
    public static void main(String args[]) throws InterruptedException {
        BoundedQueue bq = new BoundedQueue(5);
        Random rand = new Random(10);
        Thread[] producers = new Thread[10];
        Thread[] consumers = new Thread[20];
        for(int i=0;i<10;i++) {
            producers[i] = new Thread(() -> {
                try {
                    Thread.sleep(rand.nextInt(500));
                    System.out.println("Enqueued item");
                    bq.enque(rand.nextInt());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        for(int i=0;i<20;i++) {
            consumers[i] = new Thread(() -> {
                try {
                    Thread.sleep(rand.nextInt(500));
                    int item = bq.deque();
                    System.out.println("Dequeued item "+item);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        for(int i=0;i<10;i++) {
            consumers[i].start();
            producers[i].start();

        }
        for(int i=0;i<10;i++) {
            producers[i].join();
            consumers[i].join();
        }
    }
}