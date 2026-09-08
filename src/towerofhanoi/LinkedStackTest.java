// Project 3 Summer II 2026
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Your name (lamiekh)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Unit tests for the LinkedStack class.
 *
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class LinkedStackTest
    extends TestCase
{

    private LinkedStack<String> stack;

    /**
     * Sets up test fixtures before each test.
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
    }


    /**
     * Tests that a new stack is empty with size 0.
     */
    public void testInitialState()
    {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        assertEquals("[]", stack.toString());
    }


    /**
     * Tests pushing entries and checking size/isEmpty.
     */
    public void testPush()
    {
        stack.push("first");
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());

        stack.push("second");
        stack.push("third");
        assertEquals(3, stack.size());
        assertEquals("[third, second, first]", stack.toString());
    }


    /**
     * Tests peek returns the top entry without modifying the stack.
     */
    public void testPeek()
    {
        stack.push("first");
        stack.push("second");
        assertEquals("second", stack.peek());
        assertEquals(2, stack.size());
    }


    /**
     * Tests that peek throws EmptyStackException on an empty stack.
     */
    public void testPeekEmpty()
    {
        Exception exception = null;
        try
        {
            stack.peek();
        }
        catch (EmptyStackException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests pop removes and returns the top entry, decrementing size.
     */
    public void testPop()
    {
        stack.push("first");
        stack.push("second");
        assertEquals("second", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("first", stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }


    /**
     * Tests that pop throws EmptyStackException on an empty stack.
     */
    public void testPopEmpty()
    {
        Exception exception = null;
        try
        {
            stack.pop();
        }
        catch (EmptyStackException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests that clear empties the stack.
     */
    public void testClear()
    {
        stack.push("first");
        stack.push("second");
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        assertEquals("[]", stack.toString());
    }


    /**
     * Tests that toString does not modify the stack.
     */
    public void testToStringDoesNotModify()
    {
        stack.push("first");
        stack.push("second");
        stack.toString();
        assertEquals(2, stack.size());
        assertEquals("second", stack.peek());
    }
}
