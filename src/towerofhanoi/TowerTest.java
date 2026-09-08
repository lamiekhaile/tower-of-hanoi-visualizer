package towerofhanoi;

import student.TestCase;

public class TowerTest extends TestCase
{
    private Tower tower;

    public void setUp()
    {
        tower = new Tower(Position.LEFT);
    }

    public void testPosition()
    {
        assertEquals(Position.LEFT, tower.position());
        Tower rightTower = new Tower(Position.RIGHT);
        assertEquals(Position.RIGHT, rightTower.position());
    }

    public void testPushOntoEmptyTower()
    {
        Disk disk = new Disk(10);
        tower.push(disk);
        assertEquals(1, tower.size());
        assertEquals(disk, tower.peek());
    }

    public void testPushSmallerOnLarger()
    {
        tower.push(new Disk(20));
        tower.push(new Disk(10));
        assertEquals(2, tower.size());
        assertEquals(10, tower.peek().getWidth());
    }
}
