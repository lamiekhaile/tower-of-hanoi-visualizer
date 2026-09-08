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
 * Unit tests for the HanoiSolver class.
 *
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class HanoiSolverTest
    extends TestCase
{

    private HanoiSolver solver;

    /**
     * Sets up test fixtures before each test.
     */
    public void setUp()
    {
        solver = new HanoiSolver(3);
    }


    /**
     * Tests that disks() returns the number given in the constructor.
     */
    public void testDisks()
    {
        assertEquals(3, solver.disks());
    }


    /**
     * Tests that getTower returns the appropriate tower for each position.
     */
    public void testGetTower()
    {
        assertEquals(Position.LEFT, solver.getTower(Position.LEFT).position());
        assertEquals(
            Position.MIDDLE,
            solver.getTower(Position.MIDDLE).position());
        assertEquals(
            Position.RIGHT,
            solver.getTower(Position.RIGHT).position());
        assertEquals(
            Position.MIDDLE,
            solver.getTower(Position.DEFAULT).position());
    }


    /**
     * Tests moving a disk from one tower to another.
     */
    public void testMove()
    {
        Tower left = solver.getTower(Position.LEFT);
        Tower right = solver.getTower(Position.RIGHT);
        Disk disk = new Disk(10);
        left.push(disk);
        solver.move(left, right);
        assertTrue(left.isEmpty());
        assertEquals(disk, right.peek());
    }


    /**
     * Tests the solver's String representation.
     */
    public void testToString()
    {
        Tower left = solver.getTower(Position.LEFT);
        left.push(new Disk(30));
        left.push(new Disk(20));
        left.push(new Disk(10));
        assertEquals("[10, 20, 30][][]", solver.toString());
    }


    /**
     * Tests solving a three-disk puzzle.
     */
    public void testSolve()
    {
        Tower left = solver.getTower(Position.LEFT);
        left.push(new Disk(30));
        left.push(new Disk(20));
        left.push(new Disk(10));

        solver.solve();

        assertTrue(left.isEmpty());
        assertTrue(solver.getTower(Position.MIDDLE).isEmpty());
        assertEquals(3, solver.getTower(Position.RIGHT).size());
        assertEquals(10, solver.getTower(Position.RIGHT).peek().getWidth());
    }
}
