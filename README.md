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

- `HanoiSolver.java` — recursive solving algorithm and puzzle state
- `LinkedStack.java` — generic linked-stack implementation
- `Tower.java` — stack specialization that enforces Tower of Hanoi rules
- `PuzzleWindow.java` — graphical interface and visualization
- `Position.java` — tower position enum
- `ProjectRunner.java` — application entry point
- `test/` — unit tests

## Note

This project was originally developed as coursework at Virginia Tech. The GUI uses course-provided `cs2` components and the stack implementation references the course-provided `StackInterface`.

The repository currently contains the source files provided for publication. `Disk.java`, which defines the graphical disk object used by the application, was not included in the uploaded file set and will need to be added for the project to compile and run independently.
