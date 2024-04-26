public class Main {

    public static void main(String[] args) {
        testMyStack();
        testMyQueue();
        testMyMinHeap();
        testLists();
    }

    private static void testMyMinHeap() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);

        System.out.print("Min Heap: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.deleteMin() + " ");
        }
        System.out.println();
    }

    private static void testMyStack() {
        MyStack<String> stack = new MyStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push("" + i);
        }

        System.out.print("Stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void testMyQueue() {

    }

    public static void testLists() {
        // Testing MyArrayList
        System.out.println("\nTesting MyArrayList:");
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("Size: " + arrayList.size());
        System.out.print("Elements: ");
        printArray(arrayList.toArray());
        System.out.println("Index of 1: " + arrayList.indexOf(1));
        System.out.println("Last index of 2: " + arrayList.lastIndexOf(2));
        System.out.println("Is 3 in the list? " + arrayList.exists(3));

        // Testing MyLinkedList
        System.out.println("\nTesting MyLinkedList:");
        MyList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        System.out.println("Size: " + linkedList.size());
        System.out.print("Elements: ");
        printArray(linkedList.toArray());
        System.out.println("Index of 7: " + linkedList.indexOf(7));
        System.out.println("Last index of 8: " + linkedList.lastIndexOf(8));
        System.out.println("Is 9 in the list? " + linkedList.exists(9));
    }

    private static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
