package collections;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: March 8, 2023
 * A class that implements the ListADT and Iterable interfaces. It allows for
 * doubly-linked nodes to be removed, add, and otherwise manipulated. Additionally,
 * it allows for an iterator object to be used.
 */
public class DoubleLinkedList<T> implements ListADT<T>, Iterable<T> {
    
    protected DoubleNode<T> front, rear; /* Instance variables that represent
    the front and rear of the doubly linked list */
    protected int count = 0; /* Instance variable that determines the size of 
    the linked list */
    protected int modCount = 0; /* Instance variable to be used by the
    iterator */

    /**
     * Removes and returns the first element from the list.
     * @return the first element from this list.
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        
        T result = front.getElement();
        front = front.getNext();
        if (front == null) {
            rear = null;
        } else {
            front.setPrevious(null);
        }
        count--;
        modCount++;
        return result;
    }

    /**
     * Removes and returns the last element from this list.
     * @return the last element from this list.
     * @throws EmptyCollectionException 
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        
        T result = rear.getElement();
        
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.getPrevious();
            rear.setNext(null);
        }
        count--;
        modCount++;
        return result;
    }

    /**
     * Removes and returns the specified element from this list.
     * @param element - the element to be removed from the list.
     * @return 
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException 
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        boolean found = false;
        DoubleNode<T> current = front;
        while (current != null && !found) {
            if (element.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
            }
            
        }
        if (!found) {
            throw new ElementNotFoundException("Element not found");
        }
        if (current == front) {
            return removeFirst();
        }
        if (current == rear) {
            return removeLast();
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        count--;
        modCount++;
        return current.getElement();
    }

     /**
     * Returns a reference to the first element in this list.
     * @return a reference to the first element in this list.
     * @throws EmptyCollectionException 
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Empty collection");
        
        return front.getElement();
    }

    /**
     * Returns a reference to the last element in this list.
     * @return a reference to the first element in this list.
     * @throws EmptyCollectionException 
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("empty queue");
        }
        return rear.getElement();
    }

    /**
     * Returns true if this list contains the specified target element.
     * @param target - the target that is being sought in the list.
     * @return true if the list contains this element
     * @throws EmptyCollectionException 
     */
    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        DoubleNode<T> current = front;
        while (current != null) {
            if (target.equals (current.getElement())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     * @return  true if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return (front == null);
    }

    /**
     * Returns the number of elements in this list.
     * @return the integer representation of number of elements in this list.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns an iterator for the elements in this list.
     * @return an iterator over the elements in this list.
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    /**
     * Returns a string representation of this list.
     * @return a string representation of this list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode<T> doubleLink = front;
        sb.append("[");
        
        while (doubleLink != null) {
            sb.append(doubleLink.getElement());
            doubleLink = doubleLink.getNext();
            
            if (doubleLink != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
   
    /**
     * Inner class that implements the Iterator implementation and provides
     * the necessary code to use the Iterator object.
     */
    private class ListIterator implements Iterator<T> {
        
        private DoubleNode<T> current =  front; /* Instance variable (reference) 
        that represents a doubly linked node */
        private int iteratorModCount = modCount; /* Instance variable that
        represents the modification count of the object */
        
        /**
         * Method hasNext returns true if next() returns an element rather
         * than throwing an exception
         * @return - true if the iteration has more elements
         * @throws ConcurrentModificationException 
         */
        @Override
        public boolean hasNext() throws ConcurrentModificationException {
           if (modCount != iteratorModCount) {
               throw new ConcurrentModificationException();
        }
           return (current != null);
    }

        /**
         * Returns the next element in the iteration
         * @return - the next element in the iteration
         * @throws ConcurrentModificationException 
         */
        @Override
        public T next() throws ConcurrentModificationException {
            if (modCount != iteratorModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext())
                throw new NoSuchElementException();
            T result = current.getElement();
            current = current.getNext();
            return result;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator. This method can be called one per call to next()
         * @throws UnsupportedOperationException 
         */
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
        
    }
    
}
