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

import stack.StackInterface;
import java.util.EmptyStackException;

/**
 * A generic stack implemented using a singly linked chain of Nodes.
 *
 * @param <T>
 *            the type of elements stored in this stack
 * @author Lamiek Haile
 * @version 8/3/2026
 */
public class LinkedStack<T>
    implements StackInterface<T>
{

    private Node topNode;
    private int size;

    /** Creates a new, empty LinkedStack. */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }

    /** @return the size of this stack */
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void clear()
    {
        topNode = null;
        size = 0;
    }

    @Override
    public void push(T newEntry)
    {
        topNode = new Node(newEntry, topNode);
        size++;
    }

    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node currentNode = topNode;
        while (currentNode != null)
        {
            builder.append(currentNode.getData());
            if (currentNode.getNextNode() != null)
            {
                builder.append(", ");
            }
            currentNode = currentNode.getNextNode();
        }
        builder.append("]");
        return builder.toString();
    }

    private class Node
    {
        private T data;
        private Node next;

        public Node(T data)
        {
            this.data = data;
        }

        public Node(T entry, Node node)
        {
            this(entry);
            this.setNextNode(node);
        }

        public T getData()
        {
            return data;
        }

        public Node getNextNode()
        {
            return next;
        }

        public void setNextNode(Node nextNode)
        {
            this.next = nextNode;
        }
    }
}
