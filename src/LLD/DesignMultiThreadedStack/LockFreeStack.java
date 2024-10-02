package LLD.DesignMultiThreadedStack;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class LockFreeStack<T> implements Stack<T>{
    AtomicReference<StackNode<T>> head;
    AtomicLong counter = new AtomicLong();
    public LockFreeStack() {
        this.head = new AtomicReference<>();
        this.counter.set(0L);
    }

    public void push(T val) {

        StackNode<T> newNode = new StackNode<>(val);
        long backoffTime = 2L;
        while(true) {
            StackNode<T> currHead = head.get();
            newNode.setNext(currHead);
            boolean added = head.compareAndSet(currHead, newNode);
            if(added) {
               break;
            } else {
                LockSupport.parkNanos(backoffTime);
                backoffTime = Math.min(backoffTime * 2, 1024);
            }
        }
        counter.incrementAndGet();
    }

    public T pop() {
        StackNode<T> currHead = head.get();
        long backoffTime = 2L;
        while(currHead != null) {
            StackNode<T> newHead = currHead.getNext();
            if(head.compareAndSet(currHead, newHead)) {
                break;
            } else {
                LockSupport.parkNanos(backoffTime);
                backoffTime = Math.min(backoffTime * 2, 1024);
                currHead = head.get();
            }
        }
        counter.incrementAndGet();
        return currHead != null ? currHead.getVal() : null;
    }

    public long counter() {
        return counter.get();
    }

}
