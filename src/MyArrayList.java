import java.util.Iterator;

public class MyArrayList<T> implements MyList {
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

    @Override
    public void add(Object item) {

    }

    @Override
    public void set(int index, Object item) {

    }

    @Override
    public void add(int index, Object item) {

    }

    @Override
    public void addFirst(Object item) {

    }

    @Override
    public void addLast(Object item) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
