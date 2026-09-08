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

/**
 * A Tower is a LinkedStack of Disks that only allows a smaller disk to be
 * pushed on top of a larger one (or onto an empty tower).
 *
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class Tower
    extends LinkedStack<Disk>
{

    private Position position;

    /**
     * Creates a new, empty Tower at the given position.
     *
     * @param position
     *            the position of this tower (LEFT, MIDDLE, or RIGHT)
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }


    /**
     * Returns this Tower's position.
     *
     * @return the position of this tower
     */
    public Position position()
    {
        return position;
    }


    /**
     * Pushes the given disk onto this tower, if doing so is valid. A push is
     * valid if this tower is empty or if the disk on top is larger than the
     * disk being pushed.
     *
     * @param disk
     *            the disk to push
     * @precondition disk is not null
     * @precondition this tower is empty, or disk is smaller than the disk
     *                   currently on top
     */
    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException("disk cannot be null");
        }
        if (!isEmpty() && peek().compareTo(disk) <= 0)
        {
            throw new IllegalStateException(
                "Cannot place a larger disk on a smaller disk");
        }
        super.push(disk);
    }
}
