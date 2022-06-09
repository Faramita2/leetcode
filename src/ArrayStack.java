
import com.wanyi.Stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private E[] a;
    private int N;

    public ArrayStack() {
        this(1);
    }

    public ArrayStack(int n) {
        a = (E[]) new Object[n];
    }

    @Override
    public void push(E item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public E pop() {
        E e = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return e;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public E peek() {
        return a[N - 1];
    }

    private void resize(int max) {
        System.out.format("resize start, current size: %d\n", a.length);
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
        System.out.format("resize end, current size: %d\n", a.length);
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.isEmpty() = " + stack.isEmpty());

        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println("peek");
        System.out.println(stack.peek());

        System.out.println("pop");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
