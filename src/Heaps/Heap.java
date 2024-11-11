package Heaps;

public class Heap<T extends Comparable<T>> {
    private T[] heap;

    public Heap(T[] array) {
        heap = array;
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolate(i, array.length - 1);
        }
    }

    private void percolate(Integer index, Integer last) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left <= last && heap[left].compareTo(heap[largest]) > 0) {
            largest = left;
        }

        if (right <= last && heap[right].compareTo(heap[largest]) > 0) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            percolate(largest, last);
        }
    }

    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void heapSort(boolean decreasing) {
        for (int i = heap.length - 1; i > 0; i--) {
            swap(0, i);
            percolate(0, i - 1);
        }

        if (!decreasing) {
            // Reverse the array if ascending order is required
            for (int i = 0; i < heap.length / 2; i++) {
                swap(i, heap.length - 1 - i);
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < heap.length; i++) {
            System.out.println(" Element " + i + ": " + heap[i]);
        }
    }
}