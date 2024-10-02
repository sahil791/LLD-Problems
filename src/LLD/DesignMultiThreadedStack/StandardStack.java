package LLD.DesignMultiThreadedStack;

public class StandardStack<T> implements Stack<T>{
    StackNode<T> head;
    volatile long counter = 0L;

    public StandardStack() {
        this.head = null;
    }

    public synchronized void push(T val) {
        counter++;
        StackNode<T> newNode = new StackNode<>(val);
        if(this.isEmpty()) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public synchronized T pop() {
        counter++;
        if(this.isEmpty()) {
            throw new RuntimeException("Empty Stack Exception");
        }
        T val = head.getVal();
        head = head.getNext();
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public long counter() {
        return this.counter;
    }
}
