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

import java.util.Observable;

/**
 * The back-end logic for the Tower of Hanoi puzzle. Holds the three towers and
 * recursively solves the puzzle, notifying any Observers (such as PuzzleWindow)
 * each time a disk is moved.
 *
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class HanoiSolver
    extends Observable
{

    private int numDisks;
    private Tower left;
    private Tower middle;
    private Tower right;

    /**
     * Creates a new HanoiSolver for a puzzle with the given number of disks.
     * The three towers are created empty; disks are added by the front-end.
     *
     * @param numDisks
     *            the number of disks in this puzzle
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }


    /**
     * Returns the number of disks in this puzzle.
     *
     * @return the number of disks
     */
    public int disks()
    {
        return numDisks;
    }


    /**
     * Returns the Tower associated with the given Position.
     *
     * @param pos
     *            the position of the desired tower
     * @return the left, middle, or right tower, depending on pos. Returns the
     *             middle tower if pos is DEFAULT.
     */
    public Tower getTower(Position pos)
    {
        switch (pos)
        {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
            default:
                return middle;
        }
    }


    /**
     * Returns a String representation of the puzzle: the left, middle, and
     * right towers' toStrings appended together.
     *
     * @return a String representation of this puzzle
     */
    @Override
    public String toString()
    {
        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * Moves the top disk from the source tower to the destination tower, then
     * notifies observers with the destination's position.
     *
     * @param source
     *            the tower to move a disk from
     * @param destination
     *            the tower to move a disk to
     * @precondition source is not empty
     * @precondition the top disk of source can legally be pushed onto
     *                   destination
     */
    public void move(Tower source, Tower destination)
    {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Recursively solves the puzzle of moving currentDisks disks from startPole
     * to endPole, using tempPole as auxiliary storage.
     *
     * @param currentDisks
     *            the number of disks left to move in this sub-problem
     * @param startPole
     *            the tower to move disks from
     * @param tempPole
     *            the tower to use as temporary storage
     * @param endPole
     *            the tower to move disks to
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Solves the entire puzzle, moving all disks from the left tower to the
     * right tower, using the middle tower as auxiliary storage.
     */
    public void solve()
    {
        solveTowers(numDisks, left, middle, right);
    }
}
