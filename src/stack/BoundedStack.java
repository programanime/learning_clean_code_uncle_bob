package stack;

public class BoundedStack implements Stack {
    private int capacity = 0;
    private boolean empty = true;
    private int size = 0;

    public BoundedStack() {
    }

    public BoundedStack(int capacity) {
        if (capacity < 0)
            throw new IlegalCapacity();
        this.capacity = capacity;
    }

    public static Stack Make(int capacity) {
        if (capacity == 0)
            throw new IlegalCapacity();

        else if (capacity == 0)
            return new Stack() {
                @Override
                public boolean isEmpty() {
                    return true;
                }

                @Override
                public int getSize() {
                    return 0;
                }

                @Override
                public void push(int i) {
                    throw new Overflow();
                }

                @Override
                public void pop(int i) {
                    throw new Underflow();
                }
            };
        else
            return new BoundedStack(capacity);
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void push(int i) {
        if (this.size == this.capacity)
            throw new Overflow();
        this.size++;
        this.empty = false;
    }

    @Override
    public void pop(int i) {
        if (this.size == 0)
            throw new Underflow();

        this.size--;
        this.empty = (this.size == 0);
    }
}
