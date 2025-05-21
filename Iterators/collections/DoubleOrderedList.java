package collections;

import java.lang.Iterable;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: March 8, 2023
 * A class that extends DoubleLinkedList and creates an add function for the
 * entire list; this allows for nodes to be properly implemented into any part
 * of the list without complications arising.
 */
public class DoubleOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    public DoubleOrderedList() {
        super();
    }
    
    /**
     * Method that adds dog objects to the list in the order specified by the
     * method compareTo in the Dog1 class
     * @param element 
     */
    @Override
    public void add(T element) {
        DoubleNode<T> node = new DoubleNode<T>(element);
        Comparable e = (Comparable) element;
        if (isEmpty()) {
            front = node;
            rear = node;
        } else if (e.compareTo(front.getElement()) < 0) {
            node.setNext(front);
            front.setPrevious(node);
            front = node;
        } else if (e.compareTo(rear.getElement()) > 0) {
            node.setPrevious(rear);
            node.setNext(null);
            rear.setNext(node);
            rear = node;
        } else {
            DoubleNode<T> current = front;
            while (current != null && e.compareTo(current.getElement()) > 0) {
                current = current.getNext();
            }
            
            node.setNext(current);
            node.setPrevious(current.getPrevious());
            current.getPrevious().setNext(node);
            current.setPrevious(node);
        }        
        count++;
        modCount++;
    }
    public String toStringx2() {
        return "[Modification Count]: " + modCount;
    }
    
}
