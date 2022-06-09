package com.wanyi;

public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    int size();
    boolean isEmpty();
}
