import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private static class MyNode<E> {
        private MyNode<E> prev;
        private MyNode<E> next;
        private E data;
        public MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private void MyLink(MyNode<T> a, MyNode<T> b){
        if (a != null){
            a.next = b;
        }
        if (b != null){
            b.prev = a;
        }
    }

    private void MyNull(MyNode<T> a){
        a.next = null;
        a.prev = null;
    }
    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            MyLink(tail, newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        else {
            MyNode<T> current = head;
            for (int i = 0; i < index; i++)
                current = current.next;

            current.data = item;
        }
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) { // Проверяем корректность индекса
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(item);
            return;
        }
        MyNode<T> newNode = new MyNode<>(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            MyNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            MyLink(current, newNode);
            MyLink(newNode, current.next);
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        MyNull(current);
        size--;
    }

    @Override
    public void removeFirst() {
        checkIndex(0);
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
    }

    @Override
    public void removeLast() {
        checkIndex(size - 1);
        tail = tail.prev;
        size--;
        if (size == 0) {
            head = null;
        }
    }

    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            MyNode<T> current = head;
            while (current.next != null) {
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        int index = 0;
        MyNode<T> current = head;
        while (current != null) {
            newArray[index++] = current.data;
            current = current.next;
        }
        return newArray;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0 ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
