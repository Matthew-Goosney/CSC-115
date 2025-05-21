package collections;

import exceptions.EmptyQueueException;
import java.util.NoSuchElementException;

/**
 *
 * @author thwiy
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> head, tail;

    public LinkedQueue() {
    
        head = tail = null;
    }

    /**  
    * Adds one element to the rear of this queue. 
    * @param element  the element to be added to the rear of this queue  
    */
    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<T>(element);
        
        if (isEmpty())
            head = node;
        else
            tail.setNext(node);
        
        tail = node;
    }

    /**  
    * Removes and returns the element at the front of this queue.
    * @return  the element at the front of this queue
    * @throws EmptyQueueException when queue is empty
    */
    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("empty queue");
        T result = head.getElement();
        head = head.getNext();
        
        if (isEmpty())
            tail = null;

        return result;
    }

    /**  
    * Returns without removing the element at the front of this queue.
    * @return  the first element in this queue
    * @throws EmptyQueueException when queue is empty
    */
    @Override
    public T first() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("empty queue");
        
        return head.getElement();
    }

    /**
    * Returns the element's position in the queue
    * @param element which position is going to be determined
    * @return the elements position in the queue
    * @throws EmptyQueueException when queue is empty
    * @throws NoSuchElementException when element is not in the queue
    */
    @Override
    public int position(T element) throws EmptyQueueException, NoSuchElementException {
         
        if (isEmpty()) {
            throw new EmptyQueueException("invalid element");
            
        }
        int position = 1;
        LinearNode<T> current = head;
        while(current != null) {
            if (current.getElement().equals(element)) {
                return position;
            }
            position++;
            current = current.getNext();
        } throw new NoSuchElementException("Not found");
    }

    /**  
    * Returns true if this queue contains no elements.
    * @return  true if this queue is empty, false otherwise
    */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    /**  
    * Returns the number of elements in this queue. 
    * @return  the integer representation of the size of this queue
    */
    @Override
    public int size() {
        int counter = 0;
        LinearNode<T> current = head;
        while (current != null) {
            counter++;
            current = current.getNext();
        }
        return counter;
    }
    
    /**  
    * Returns a string representation of this queue. 
    * @return  the string representation of this queue
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<T> queueRepresentation = head;
        sb.append("[");
        
        while (queueRepresentation != null) {
            sb.append(queueRepresentation.getElement());
            queueRepresentation = queueRepresentation.getNext();
            
            if (queueRepresentation != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
