package stack;

public class MyStack {
    private final int stackSize;
    private int count;
    private String[] elements;

    public MyStack(int stackSize) {
        this.stackSize = stackSize;
        elements = new String[stackSize];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(String string) {
        elements[count++] = string;
    }

    public String pop() {
        if (count == 0) throw new StackUnderflowException("Stack is full");
        return elements[--count];
    }

    public int size() {
        return count;
    }
}
