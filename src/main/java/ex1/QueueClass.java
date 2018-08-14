import java.util.ArrayList;
import java.util.List;

public class QueueClass implements Queue {

    private List<Object> queue = new ArrayList<>();

    @Override
    public void enqueue(Object o) {
        queue.add(o);
    }

    @Override
    public Object dequeue() {
        Object object = queue.get(0);
        queue.remove(0);
        return object;
    }

    @Override
    public int size() {
        return queue.size();
    }

}
