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

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

/**
 * Represents a single disk in the Tower of Hanoi puzzle. A Disk is a
 * rectangular Shape whose width determines its relative size compared to other
 * disks.
 *
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class Disk
    extends Shape
    implements Comparable<Disk>
{

    /**
     * Creates a new Disk with the given width, a height of
     * PuzzleWindow.DISK_HEIGHT, positioned at (0, 0), and a randomly generated
     * background color.
     *
     * @param width
     *            the width of this disk
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom random = new TestableRandom();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        this.setBackgroundColor(new Color(red, green, blue));
    }


    /**
     * Compares this Disk to another Disk based on width.
     *
     * @param otherDisk
     *            the disk to compare against
     * @return a negative number if this disk is smaller, a positive number if
     *             this disk is larger, or zero if they are the same width
     * @precondition otherDisk is not null
     */
    @Override
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException("otherDisk cannot be null");
        }
        return this.getWidth() - otherDisk.getWidth();
    }


    /**
     * Returns the width of this Disk as a String.
     *
     * @return the width of this disk, as a String
     */
    @Override
    public String toString()
    {
        return "" + this.getWidth();
    }


    /**
     * Two Disks are equal if they have the same width.
     *
     * @param obj
     *            the object to compare against
     * @return true if obj is a Disk with the same width as this Disk
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Disk))
        {
            return false;
        }
        Disk otherDisk = (Disk)obj;
        return this.getWidth() == otherDisk.getWidth();
    }
}
