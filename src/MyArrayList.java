import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int size;

    private  void checkIndex(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("incorrect");
    }

    public MyArrayList(){
        arr = new Object[10];
        size = 0;
    }
/*Increase the size of the array by 2 times if there is not enough space for all the elements
and also transfer all old elements to the new array */
    @Override
    public void add(Object item) {
        if (size >= arr.length){
            int newSize = arr.length * 2;
            Object[] newArr = new Object[newSize];
            for (int i = 0; i < size; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size++] = item;

    }

/*add a new element value at the current index and increase the array size by 1 */
    @Override
    public void set(int index, Object item) {
        checkIndex(index);
        arr[index] = item;
    }

/*all elements to the right of the index are shifted to the right for
the new element and the array size is increased by 1 */
    @Override
    public void add(int index, Object item) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        add(item);
        for (int i = size - 1; i >= index; i--){
            arr[i + 1] = arr[i];
        }
        arr[index] = item;
        size++;
    }

    @Override
    public void addFirst(Object item) {
        add(0, item);
    }

    @Override
    public void addLast(Object item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) arr[index];
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
        for (int i = index; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[size -1] = null;
        size--;
    }

    @Override
    public void removeFirst() {
        arr[0] = null;
        size -= 1;
    }

    @Override
    public void removeLast() {
        arr[size - 1] = null;
        size -= 1;
    }
/*We use the bubble sort method and the "Comparable" interface to compare
objects of type T and sort them according to their order */
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) arr[j]).compareTo((T) arr[j + 1]) > 0) {
                    T temp = (T) arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(object)) {
                return i;
            }
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
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

   @Override
    public Iterator iterator() {
        return null;
    }
}
