package Listen;

public class MyArrayList<T extends Comparable<T>> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elements = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    public void addSorted(T data) {
        if (size >= elements.length) {
            throw new IllegalStateException("ArrayList is full");
        }

        int index = size;
        while (index > 0 && elements[index - 1].compareTo(data) > 0) {
            elements[index] = elements[index - 1];
            index--;
        }
        elements[index] = data;
        size++;
    }

    public MyArrayList<T> sortList() {
        MyArrayList<T> sortedList = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            sortedList.addSorted(elements[i]);
        }
        return sortedList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}