package Stacks;

import OneWay.OneWayList;

class MyStack<T extends Comparable<T>> {
    private OneWayList<T> stack;
    private int maxSize;
    private int currentSize;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new OneWayList<>();
        this.currentSize = 0;
    }

    public void push(T item) {
        if (currentSize >= maxSize) {
            throw new IllegalStateException("Stack is full");
        }
        stack.addFirst(item);
        currentSize++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = stack.getFirst();
        stack.removeFirst();
        currentSize--;
        return item;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}