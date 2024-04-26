public class MyQueue<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;


    public MyQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }


    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (head == null) { // Check if the queue is empty
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head == null) { // Update tail if queue becomes empty
            tail = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (head == null) { // Check if the queue is empty
            return null;
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
