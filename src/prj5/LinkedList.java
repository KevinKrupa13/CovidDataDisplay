package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList class is our implementation
 * of a DoubleLinkedLinked
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 * 
 * @param <E>
 *            Type of variable in the database
 */
public class LinkedList<E> implements LList<E> {

    /**
     * Private node class used by the linkedlist class
     * 
     * @author Kevin Krupa (kevinkrupa13)
     * @author Suha Dewan (suhad)
     * 
     * @version 2020.21.11
     * 
     * @param <E>
     *            Data type used in node
     */
    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Node constructor
         * 
         * @param prev
         *            Previous node reference
         * @param d
         *            Data
         * @param next
         *            Next node reference
         */
        public Node(Node<E> prev, E d, Node<E> next) {
            previous = prev;
            data = d;
            this.next = next;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<E> n) {
            previous = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<E> previous() {
            return previous;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData() {
            return data;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    /**
     * Create a new DLList object.
     */
    public LinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj) {
        return lastIndexOf(obj) != -1;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end
     */
    public void add(E newEntry) {
        add(size(), newEntry);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(E obj) {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<E> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1; // if we do not find it
    }


    /**
     * Removes the element at the specified index from the list
     *
     * @param index
     *            where the object is located
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     * @return true if successful
     */
    public boolean remove(int index) {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;
    }


    /**
     * Removes the first object in the list that .equals(obj)
     *
     * @param obj
     *            the object to remove
     * @return true if the object was found and removed
     */

    public boolean remove(E obj) {
        Node<E> current = head.next();
        while (!current.equals(tail)) {
            if (current.getData().equals(obj)) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty()) {
            Node<E> currNode = head.next();
            while (currNode != tail) {
                E element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail) {
                    builder.append(", ");
                }
                currNode = currNode.next();
            }
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * Private helper method for sorting
     * 
     * @param comp
     *            Comparator input
     * @param nodeToInsert
     *            Node input automatically passed
     */
    private void sort(Comparator<E> comp, Node<E> nodeToInsert) {
        E item = nodeToInsert.getData();
        Node<E> currentNode = head.next();
        Node<E> prevNode = head;
        while ((currentNode != null) && (comp.compare(item, currentNode
            .getData()) > 0)) {
            prevNode = currentNode;
            currentNode = currentNode.next();
        }
        if (prevNode != head) {
            prevNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(prevNode);
            nodeToInsert.setNext(currentNode);
            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
        }
        else {
            nodeToInsert.setNext(head.next());
            head.setNext(nodeToInsert);
        }
    }


    /**
     * Sort method for this linked list. Sorts with the
     * insertion sort method
     * 
     * @param comp
     *            Comparator input
     */
    public void insertionSort(Comparator<E> comp) {
        Node<E> firstNode = head.next();
        if (size() > 1) {
            Node<E> unsorted = firstNode.next();
            firstNode.next().setPrevious(null);
            firstNode.setNext(null);
            while (unsorted != tail && unsorted != null) {
                Node<E> nodeToInsert = unsorted;
                unsorted = unsorted.next();
                sort(comp, nodeToInsert);
            }
        }
    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> iterator() {
        return new DLListIterator<E>();
    }

    /**
     * Private iterator class used by the linked
     * list class
     * 
     * @author Kevin Krupa (kevinkrupa13)
     * @author Suha Dewan (suhad)
     * 
     * @version 2020.21.11
     * 
     * @param <A>
     *            Data type used by iterator
     */
    private class DLListIterator<A> implements Iterator<E> {

        private int index;

        /**
         * Creates a new DLListIterator
         */
        public DLListIterator() {
            index = 0;
        }


        /**
         * Returns true if this list iterator has more elements when traversing
         * the list in the reverse direction.
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return index < size();
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            index++;
            return get(index - 1);
        }

    }
}
