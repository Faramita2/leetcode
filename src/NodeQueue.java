import com.wanyi.Node;
import com.wanyi.Queue;

public class NodeQueue<E> implements Queue<E> {
    public Node<E> first;
    public Node<E> last;
    int N;

    @Override
    public void enqueue(E e) {
        Node<E> oldLast = last;
        last = new Node<>();
        last.e = e;

        if (N == 0) first = last;
        else oldLast.next = last;

        N++;
    }

    @Override
    public E dequeue() {
        E e = first.e;

        first = first.next;

        N--;
        if (isEmpty()) last = null;
        return e;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    public static void main(String[] args) {

    }
}
