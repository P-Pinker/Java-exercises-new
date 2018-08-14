package ex2;

import java.util.Deque;
import java.util.LinkedList;

public class StackImpl<T> implements Stack<T> {

    Deque<T> stack = new LinkedList<>();

    @Override
    public void push(T o) {
        stack.push(o);
    }

    @Override
    public T pop() throws IllegalStateException {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalStateException("Error");
        }
    }

    @Override
    public T peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            throw new IllegalStateException("Error");
        }
    }

}