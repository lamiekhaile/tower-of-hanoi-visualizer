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

import student.TestCase;

/**
 * Unit tests for the Disk class.
 *
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class DiskTest
    extends TestCase
{

    private Disk disk10;
    private Disk disk20;

    /** Sets up test fixtures before each test. */
    public void setUp()
    {
        disk10 = new Disk(10);
        disk20 = new Disk(20);
    }

    /** Tests compareTo. */
    public void testCompareTo()
    {
        assertTrue(disk10.compareTo(disk20) < 0);
        assertTrue(disk20.compareTo(disk10) > 0);
        assertEquals(0, disk10.compareTo(new Disk(10)));
    }

    /** Tests compareTo with null. */
    public void testCompareToNull()
    {
        Exception exception = null;
        try { disk10.compareTo(null); }
        catch (IllegalArgumentException e) { exception = e; }
        assertNotNull(exception);
    }

    /** Tests toString. */
    public void testToString()
    {
        assertEquals("10", disk10.toString());
        assertEquals("20", disk20.toString());
    }

    /** Tests equals. */
    public void testEquals()
    {
        assertTrue(disk10.equals(new Disk(10)));
        assertFalse(disk10.equals(disk20));
        assertFalse(disk10.equals("10"));
        assertFalse(disk10.equals(null));
    }

    /** Tests width. */
    public void testWidth()
    {
        assertEquals(10, disk10.getWidth());
        assertEquals(20, disk20.getWidth());
    }
}
