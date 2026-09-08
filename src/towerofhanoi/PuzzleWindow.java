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

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle (Fall
 * 2024)
 *
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class PuzzleWindow
    implements Observer
{

    private HanoiSolver game;
    private Shape left;
    private Shape center;
    private Shape right;
    private Window window;
    public static final int WIDTH_FACTOR = 12;
    public static final int DISK_GAP = 2;
    public static final int DISK_HEIGHT = 15;

    public PuzzleWindow(HanoiSolver g)
    {
        this.game = g;
        game.addObserver(this);

        window = new Window("Tower of Hanoi");
        window.setSize(600, 400);

        int poleHeight = 200;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((200 - 15 / 2), poleY, 15, poleHeight,
            new Color(50, 50, 50));
        center = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));

        for (int width = (game.disks() + 1) * WIDTH_FACTOR;
            width > WIDTH_FACTOR; width -= WIDTH_FACTOR)
        {
            Disk disk = new Disk(width);
            window.addShape(disk);
            game.getTower(Position.LEFT).push(disk);
            moveDisk(Position.LEFT);
        }

        window.addShape(left);
        window.addShape(center);
        window.addShape(right);

        Button solveButton = new Button("Solve");
        window.addButton(solveButton, WindowSide.SOUTH);
        solveButton.onClick(this, "clickedSolve");
    }

    private void moveDisk(Position position)
    {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        if (position == Position.LEFT)
        {
            currentPole = left;
        }
        else if (position == Position.RIGHT)
        {
            currentPole = right;
        }
        else
        {
            currentPole = center;
        }

        int newX = currentPole.getX() + (currentPole.getWidth() / 2)
            - (currentDisk.getWidth() / 2);
        int stackHeightBelow = game.getTower(position).size() - 1;
        int newY = currentPole.getY() + currentPole.getHeight() - DISK_HEIGHT
            - (stackHeightBelow * (DISK_HEIGHT + DISK_GAP));

        currentDisk.moveTo(newX, newY);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if (arg.getClass() == Position.class)
        {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }

    public void clickedSolve(Button button)
    {
        button.disable();
        new Thread() {
            public void run()
            {
                game.solve();
            }
        }.start();
    }

    private void sleep()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
        }
    }
}
