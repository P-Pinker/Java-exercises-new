package ex1;

import java.util.LinkedList;

public class QueueImpl<T> implements Queue<T> {

    LinkedList<T> queue = new LinkedList<>();

    @Override
    public void enqueue(T o) {
        queue.addLast(o);
    }

    @Override
    public T dequeue() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();
        } else {
            throw new IllegalStateException("Error");
        }
    }

    @Override
    public int size() {
        return queue.size();
    }


//      SOLUTION II
//    java.util.Queue<T> queue = new LinkedList<>();
//
//    public QueueImpl() {
//        this.queue = queue;
//    }
//
//    @Override
//    public void enqueue(T o) {
//        queue.add(o);
//    }
//
//    @Override
//    public T dequeue() {
//        return queue.poll();
//    }
//
//    @Override
//    public int size() {
//        return queue.size();
//    }

}