package LLD.DesignMultiThreadedStack;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        StandardStack<Integer> stack = new StandardStack<>();
        Random random = new Random(1000);
//        stack.push(10);
//        stack.push(11);
//        stack.push(12);

//        while(!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
//
//        StandardStack<String> chStack = new StandardStack<>();
//        chStack.push("sahil");
//        chStack.push("rahul");
//        chStack.push("visa");
//
//        while(!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(8);
        executor.execute(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    stack.push(random.nextInt(2000000));
                }
            } catch (Exception e) {
                System.out.println("Task 1 interrupted, exiting...");
            }
        });

        executor.execute(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    stack.push(random.nextInt(2000000));
                }
            } catch (Exception e) {
                System.out.println("Task 2 interrupted, exiting...");
            }
        });


        executor.execute(() -> {
            try {
                while (!Thread.currentThread().isInterrupted() && !stack.isEmpty()) {
                    System.out.println(stack.pop());
                }
            } catch (Exception e) {
                System.out.println("Task 3 interrupted, exiting...");
            }
        });

        executor.shutdown();
        if(!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("%,d operations performed in 10 secs",stack.counter));
    }
}
