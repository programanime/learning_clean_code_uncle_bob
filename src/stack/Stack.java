package stack;

public interface Stack {
    boolean isEmpty();

    int getSize();

    void push(int i);

    void pop(int i);

    public class Overflow extends RuntimeException {}
    public class Underflow extends RuntimeException {}
    public class IlegalCapacity extends RuntimeException {}
}
