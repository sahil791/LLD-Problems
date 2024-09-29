package LLD.DesignMultiThreadedStack;

public class StackNode<T> {
    private T val;
    private StackNode<T> next;

    public StackNode() {}
    public StackNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}
