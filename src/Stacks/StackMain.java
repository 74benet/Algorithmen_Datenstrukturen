package Stacks;

public class StackMain {
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        stack.push("hello");
        stack.push("world");
        System.out.println(stack.pop());
    }
}