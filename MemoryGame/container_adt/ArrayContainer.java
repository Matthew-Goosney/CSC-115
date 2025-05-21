package container_adt;

import exception.EmptyContainerException;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.lang.Math;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: February 1st, 2023 
 * A class that implements the interface ContainerADT using an array. Using
 * Generics, the code allows for the container to be easily manipulated and
 * tested via an ulterior application
*/
public class ArrayContainer<T> implements ContainerADT<T> {
    
    private T[] contents; // Instance array of Generic type
    private final int DEFAULT_CAPACITY = 100; /* Instance variable that 
    determines the default capacity of an array */
    private int counter = 0; /* Instance variable that represents an element
    of the array, allowing it to be incremented and decremented */
    
    /**
     * An empty constructor method that creates an array with a default capacity
     * of 100 elements
     */
    public ArrayContainer() {
        contents = (T[])(new Object [DEFAULT_CAPACITY]);
    }
    
    /**
     * A constructor method that creates an array with an undetermined capacity,
     * allowing for it to be determined elsewhere and tested accordingly
     * @param capacity - capacity variable that allows for the container to be
     * called to and given a set number of elements at a different time
     */
    public ArrayContainer(int capacity) {
        contents = (T[])(new Object [capacity]);
    }

    /**
     * A method that allows for the size of the container to be incremented
     * @param element - a generic element that describes a single object
     * inside of the container
     */
    @Override
    public void add(T element) {
        contents = Arrays.copyOf(contents, contents.length + 1);
        contents[counter] = element;
        counter++;
    }

    /**
     * A method that removes a random element in the container
     * @return - returns a random element from the container to be removed
     * @throws EmptyContainerException 
     */
    @Override
    public T removeRandom() throws EmptyContainerException {
        if (isEmpty())
            throw new EmptyContainerException("empty container");
        
        int w = (int) (Math.random() * counter);
        T result = contents[w];
        contents[w] = null;
        w--;
        
        return result;
    }

    /**
     * A method that allows for the size of the container to be decremented
     * @param element - a generic element that describes a single object
     * inside of the container
     * @return - returns an element from the container specific by the
     * parameter
     * @throws EmptyContainerException
     * @throws NoSuchElementException 
     */
    @Override
    public T remove(T element) throws EmptyContainerException, NoSuchElementException {
        if (isEmpty())
            throw new EmptyContainerException("empty container");
    
        for(int i = 0; i < contents.length; i++){
            if (contents[i] == element){
                contents[i] = null;
            }
        } 
        T result = contents[counter];
        counter--;
        
        return result;
    }

    /**
     * A method that clears the contents of the container
     */
    @Override
    public void clear() {
        for(int i = 0; i < contents.length; i++){
            contents[i] = null;
        }
        counter = 0;
    }

    /**
     * A method that targets a specific element in the container
     * @param target - generic variable that targets a specific element in 
     * the container
     * @return - boolean to specify if the element already exists in the 
     * container. Returns true if the container contains the parameter, 
     * while returning false if not
     */
    @Override
    public boolean contains(T target) {
        for(int i = 0; i < contents.length; i++){
           if(contents[i] == target){
                return true;
           }
        } 
        return false;
    }

    /**
     * A method that determines whether or not the container is empty
     * @return - returns a boolean that specifies whether the order is true
     * or false (if it is empty or not)
     */
    @Override
    public boolean isEmpty() {
        return (counter == 0);
    }

     /**
     * A method that denotes the maximum size of the container
     * @return - returns the size of the container 
     */
    @Override
    public int maxSize() {
        return contents.length;
    }
     
    /**
     * A method that returns the number of elements in the container
     * @return - returns the number of elements in the container 
     */
    @Override
    public int size() {
        int x = 0;
        for(int i = 0; i < contents.length; i++){
            if(contents[i] != null) {
                x++;
            }
        }
        return x;
    }
    
    /**
     * A method that showcases a string representing the container
     * and its contents
     * @return - returns a string
     */
    @Override
    public String toString(){
        for(int i = 0; i < contents.length; i++){
            System.out.println(contents[i]);
        }
        return "";
    }
}
