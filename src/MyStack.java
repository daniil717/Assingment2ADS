public class MyStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] stack;
    private int top;

    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    public MyStack(int initialCapacity) {
        stack = (T[]) new Object[initialCapacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void push(T item) {
        if (size() == stack.length) {
            resize(2 * stack.length);
        }
        stack[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        T item = stack[top];
        stack[top--] = null; // Avoid memory leaks
        if (size() > 0 && size() == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top];
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i <= top; i++) {
            newArray[i] = stack[i];
        }
        stack = newArray;
    }

    public void clearStack() {
        top = -1;
    }

    public int search(Object object) {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        for (int i = 0; i <= top; i++) {
            if (stack[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
}
