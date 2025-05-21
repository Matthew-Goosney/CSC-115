package container_adt;
import exception.EmptyContainerException;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: February 1st, 2023 
 * An interface using Generics that describes a container that can 
 * manipulate a container.
 * @param <T> - Generic abstract interface to be implemented elsewhere
*/

public interface ContainerADT<T> {

    /**
     * An abstract method that allows for an element to be added to the 
     * container
     * @param element - a generic element that describes a single object
     * inside of the container
     */
    public void add(T element);
    
    /**
     * An abstract method that randomly removes an element from the container
     * @return - returns a random element from the container to be removed
     * @throws EmptyContainerException
     */
    public T removeRandom() throws EmptyContainerException;
    
    /**
     * An abstract method that allows for an element to be removed from the 
     * container
     * @param element - generic element that describes a single object inside
     * of the container
     * @return - returns an element from the container specific by the
     * parameter
     * @throws EmptyContainerException
     * @throws java.util.NoSuchElementException 
     */
    public T remove(T element) throws EmptyContainerException, 
            java.util.NoSuchElementException;
    
    /**
     * An abstract method that clears the contents of the container
     */
    public void clear();
    
    /**
     * An abstract method that targets a specific element in the container
     * @param target - generic variable that targets a specific element in 
     * the container
     * @return - boolean to specify if the element already exists in the 
     * container. Returns true if the container contains the parameter, 
     * while returning false if not
     */
    public boolean contains(T target);
    
    /**
     * An abstract method that determines whether or not the container
     * is empty
     * @return - returns a boolean that specifies whether the order is true
     * or false (if it is empty or not)
     */
    public boolean isEmpty();
    
    /**
     * An abstract method that denotes the maximum size of the container
     * @return - returns the size of the container 
     */
    public int maxSize();
    
     /**
     * An abstract method that denotes the size of the container
     * @return - returns the size of the container 
     */
    public int size();
    
    /**
     * An abstract method that showcases a string representing the container
     * and its contents
     * @return - returns a string
     */
    @Override
    public java.lang.String toString();
        
}
