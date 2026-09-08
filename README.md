# Tower of Hanoi Visualizer

A Java implementation of the classic Tower of Hanoi puzzle featuring a recursive solver and graphical visualization.

## What I Built

- Recursive Tower of Hanoi solving algorithm
- Generic `LinkedStack<T>` implemented with a singly linked structure
- Three tower objects that enforce legal disk placement
- Object-oriented separation between puzzle logic and visualization
- Observer-based updates so the GUI reflects each move made by the solver
- Background solving thread so the interface can update while the algorithm runs
- Unit tests for the project's core data structures and solver logic

## Concepts Demonstrated

Java, recursion, stacks, linked data structures, generics, inheritance, object-oriented design, the Observer pattern, exception handling, unit testing, and GUI programming.

## Project Structure

- `src/towerofhanoi/HanoiSolver.java` — recursive solving algorithm and puzzle state
- `src/towerofhanoi/LinkedStack.java` — generic linked-stack implementation
- `src/towerofhanoi/Tower.java` — stack specialization that enforces Tower of Hanoi rules
- `src/towerofhanoi/Disk.java` — graphical disk object and size comparison logic
- `src/towerofhanoi/PuzzleWindow.java` — graphical interface and visualization
- `src/towerofhanoi/Position.java` — tower position enum
- `src/towerofhanoi/ProjectRunner.java` — application entry point
- `test/` — unit tests

## Note

This project was originally developed as coursework at Virginia Tech. The GUI uses course-provided `cs2` components, and the project also depends on course-provided support classes such as `StackInterface` and `TestableRandom`.
