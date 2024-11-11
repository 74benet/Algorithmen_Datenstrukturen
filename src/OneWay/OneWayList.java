package OneWay;

public class OneWayList<T extends Comparable<T>>{
    protected OneWayElement<T> listHead;
    public OneWayList()
    {
        listHead = new OneWayElement<>(null, null);
    }

    public void addSorted(T data) {
        OneWayElement<T> newElement = new OneWayElement<>(data, null);
        OneWayElement<T> current = listHead;

        while (current.getNext() != null && current.getNext().getData().compareTo(data) < 0) {
            current = current.getNext();
        }

        newElement.setNext(current.getNext());
        current.setNext(newElement);
    }

    public OneWayList<T> sortList() {
        OneWayList<T> sortedList = new OneWayList<>();
        OneWayElement<T> current = listHead.getNext();

        while (current != null) {
            sortedList.addSorted(current.getData());
            current = current.getNext();
        }

        return sortedList;
    }

    public void addFirst(T data) {
        OneWayElement<T> elem = new OneWayElement<>(data, listHead.getNext());
        listHead.setNext(elem);
    }

    public void removeFirst(){
        listHead.setNext(listHead.getNext().getNext());
    }

    public T getFirst() {
        if (!this.isEmpty())
            return listHead.getNext().getData();
        else return (null);
    }
    public OneWayList<T> getTail()
    {
        OneWayList<T> result = new OneWayList<T>();
        if(!this.isEmpty())
            result.listHead = listHead.getNext();
        return(result);
    }
    public int getLength() {
        int num = 0;
        OneWayElement<T> elem = listHead.getNext();
        while (elem != null)
        {
            elem = elem.getNext();
            num += 1;
        }
        return num;
    }
    public  boolean isEmpty()
    {
        return listHead.getNext() == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        OneWayElement<T> current = listHead.getNext();
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

}
