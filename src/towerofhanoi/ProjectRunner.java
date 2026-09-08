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
 * Contains the main method that launches the Tower of Hanoi puzzle.
 *
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class ProjectRunner
{

    /**
     * Launches the Tower of Hanoi puzzle. Accepts an optional single
     * command-line argument specifying the number of disks to use (defaults to
     * 5 if no argument, or more than one argument, is given).
     *
     * @param args
     *            optional single argument: number of disks
     */
    public static void main(String[] args)
    {
        int disks = 5;
        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        new PuzzleWindow(new HanoiSolver(disks));
    }
}
