package Listen;

import OneWay.OneWayList;

public class SortMain {
    public static void main(String[] args) {
        // Demonstration mit OneWayList
        System.out.println("Demonstration mit OneWayList:");
        OneWayList<Integer> oneWayList = new OneWayList<>();
        for (int value : new int[]{9, 1, 2, 5, 8}) {
            oneWayList.addFirst(value);
        }

        OneWayList<Integer> sortedOneWayList = oneWayList.sortList();
        System.out.println("Sortierte Liste: " + sortedOneWayList);

        sortedOneWayList.addSorted(7);
        System.out.println("Nach Hinzufügen von 7: " + sortedOneWayList);

        // Demonstration mit MyArrayList
        System.out.println("\nDemonstration mit MyArrayList:");
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int value : new int[]{9, 1, 2, 5, 8}) {
            myArrayList.addSorted(value);
        }

        System.out.println("Sortierte ArrayList: " + myArrayList);

        myArrayList.addSorted(7);
        System.out.println("Nach Hinzufügen von 7: " + myArrayList);
    }
}