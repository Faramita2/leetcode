package com.wanyi;

public class FixedCapacityStack<E> {
    private E[] a;
    private int N;

    public FixedCapacityStack(int n) {
        a = (E[]) new Object[n];
    }

    public void push(E item) {
        a[N++] = item;
    }

    public E pop() {
        return a[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(5);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
