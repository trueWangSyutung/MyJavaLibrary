package cn.syutung.ListLibrary;

public interface Queue<T> {
    void enqueue(T ap);
    Object dequeue();
    boolean isEmpty();
    int size();
}
