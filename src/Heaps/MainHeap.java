package Heaps;

public class MainHeap {
    public static void main(String[] args) {
        Integer[] array = {16, 5, 1, 11, 8, 3, 12, 10, 9, 2, 4, 7, 13, 6};

        Heap<Integer> heapDesc = new Heap<>(array.clone());
        System.out.println("Heap before sorting:");
        heapDesc.printHeap();

        // Descending order
        heapDesc.heapSort(true);
        System.out.println("\nSorted in descending order:");
        heapDesc.printHeap();

        // Ascending order
        Heap<Integer> heapAsc = new Heap<>(array.clone());
        heapAsc.heapSort(false);
        System.out.println("\nSorted in ascending order:");
        heapAsc.printHeap();
    }
}