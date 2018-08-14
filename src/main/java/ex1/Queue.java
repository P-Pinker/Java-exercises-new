public interface Queue<T> {

    void enqueue(T o);

    T dequeue();

    int size();
}
