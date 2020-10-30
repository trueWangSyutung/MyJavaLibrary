package cn.syutung.Library;

public interface Queue<T> {
    void enqueue(T ap);
    Object dequeue();
    boolean isEmpty();
    int size();
}
