import com.wanyi.Node;
import com.wanyi.Stack;

import java.util.Iterator;

public class NodeStack<E> implements Stack<E>, Iterable<E> {
    private Node<E> first;
    private int N;

    @Override
    public void push(E e) {
        Node<E> oldFirst = first;
        first = new Node<>();
        first.e = e;
        first.next = oldFirst;
        N++;
    }

    @Override
    public E pop() {
        E e = first.e;
        first = first.next;
        N--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public E peek() {
        return first.e;
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeStackIterator();
    }

    private class NodeStackIterator implements Iterator<E> {
        Node<E> current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            E e = current.e;
            current = current.next;
            return e;
        }
    }

    public static void main(String[] args) {
        Stack<String> s = new NodeStack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.println(s.peek());
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack");
    }
}
