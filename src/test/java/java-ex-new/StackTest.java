import static org.junit.Assert.*;

import ex2.Stack;
import org.junit.Test;

public class StackTest {

    @Test
    public void shouldPushAndPopItems() {
        Stack<String> stack = new StackImpl<>();

        stack.push("AAA");
        stack.push("BBB");
        stack.push("CCC");
        assertEquals("CCC", stack.peek());
        assertEquals("CCC", stack.peek());

        assertEquals("CCC", stack.pop());
        assertEquals("BBB", stack.peek());

        assertEquals("BBB", stack.pop());
        assertEquals("AAA", stack.peek());

        stack.push("XXX");
        assertEquals("XXX", stack.peek());
        assertEquals("XXX", stack.pop());
        assertEquals("AAA", stack.peek());
        assertEquals("AAA", stack.pop());

        try {
            stack.peek();
            fail("Should throw an exception");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }

        try {
            stack.pop();
            fail("Should throw an exception");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
    }
}