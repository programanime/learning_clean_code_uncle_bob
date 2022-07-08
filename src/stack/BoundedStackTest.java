package stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoundedStackTest {
    private Stack boundedStack;

    @Before
    public void setUp() throws Exception {
        boundedStack = BoundedStack.Make(2);
    }

    @Test
    public void newlyCreateStack_ShouldBeEmpty() throws Exception{
        Stack boundedStack = new BoundedStack(10);
        assertTrue(boundedStack.isEmpty());
        assertEquals(0, boundedStack.getSize());
    }

    @Test
    public void AfterOnePush_StackSizeShouldBeOne() throws Exception {
        Stack boundedStack = new BoundedStack(10);
        boundedStack.push(1);
        assertEquals(1, boundedStack.getSize());
        assertFalse(boundedStack.isEmpty());
    }

    @Test(expected = Stack.Overflow.class)
    public void WhenPushedPastLimit_StackOverflows() throws Exception {
        Stack boundedStack = new BoundedStack();
        boundedStack.push(1);
        boundedStack.push(1);
        boundedStack.push(1);
    }

    @Test(expected = Stack.Underflow.class)
    public void WhenEmptyStackIsPopped_ShouldThrowUnderflow() throws Exception {
        boundedStack.pop(1);
    }
}
