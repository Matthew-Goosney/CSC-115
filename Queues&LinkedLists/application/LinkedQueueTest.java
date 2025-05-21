package application;

import collections.*;
import exceptions.*;
import java.util.NoSuchElementException;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: February 28 - March 2, 2023 A
 * class that tests and properly showcases all of the methods from the
 * LinkedQueue.java
 */
public class LinkedQueueTest {

    /**
     * Main method that tests the methods from the LinkedQueue.java - manipulates
     * the queue and tests in enqueue, dequeue, size, first, position, toString,
     * and isEmpty methods.
     * @param args 
     */
    public static void main(String[] args) {
        LinkedQueue<String> q = new LinkedQueue<String>();
        
        //Enqueue system & tring placement
        q.enqueue("Arbiter");
        q.enqueue("Boolean");
        q.enqueue("Cookinator");
        q.enqueue("Desperado");
        q.enqueue("Edna");
        q.enqueue("Fluorine");
        System.out.println("Initial Queue: " + q.toString());

        //Dequeue system & size display
        try {
            q.dequeue();
            q.dequeue();
            q.dequeue();
            q.dequeue();
            q.dequeue();
        } catch (EmptyQueueException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Dequeued Queue: " + q.toString());
        
        //Testing the First() and Position() methods in the LinkedQueue implementation
        try {
            System.out.println("First Element: " + q.first());
            q.enqueue("Arbitrary");
            q.enqueue("Banana");
            q.enqueue("Desperado");
            System.out.println("Position: " + q.position("Desperado"));
        } catch (EmptyQueueException | NoSuchElementException ex) {
            System.out.println("catch" + ex.getMessage());
        }
        System.out.println("Manipulated Queue: " + q.toString());
    
        System.out.println("MQueue Empty?: " + q.isEmpty()); //Determining whether the queue is empty
        System.out.println("MQueue Size: " + q.size());q.size(); //Showcasing the the size of the queue after the above try-block procedure

        //Displaying the merged queue
        LinkedQueue q1 = new LinkedQueue();
        LinkedQueue q2 = new LinkedQueue();
        
        //Adding elements to their corresponding queues
        q1.enqueue(19);
        q1.enqueue(6);
        q1.enqueue(12);
        q2.enqueue(700);
        q2.enqueue(800);
        q2.enqueue(900);
        
        //Merging the two queues together
        LinkedQueue mergedQueue = merge(q1, q2);
        
        //Displaying the merged queue
        System.out.println("Merged Queue: " + mergedQueue.toString());
    }

    /**
     * Method that receives two queues and creates a new queue with objects
     * from both queues
     * @param q1 - Queue1 that is used to create a merged queue
     * @param q2 - Queue2 that is used to create a merged queue
     * @return 
     */
    public static LinkedQueue merge(LinkedQueue q1, LinkedQueue q2) {
        LinkedQueue merge = new LinkedQueue();

        try {
            while (!q1.isEmpty() && !q2.isEmpty()) {
                int element;
                if(!q1.isEmpty()) {
                   element = (int) q1.dequeue();
                    merge.enqueue(element); 
                }
                if(!q2.isEmpty()) {
                    element = (int) q2.dequeue();
                    merge.enqueue(element);
                }
            }
            
        } catch (EmptyQueueException | NoSuchElementException ex) {
            System.out.println("Error occurred while merging the queues: " 
                    + ex.getMessage());
        }
        
        return merge;
    }
}
