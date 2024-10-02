package LLD.DesignMultiThreadedStack;

public interface Stack<T> {
    void push(T val);
    T pop();
    // totoal number of push|pop operations performed
    long counter();
}