package collections;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: March 8, 2023
 * OrderedListADT defines the interface to an ordered list collection. Only 
 * comparable elements are stored, kept in the order determined by the
 * inherent relationship among the elements.
 */
public interface OrderedListADT<T> extends ListADT<T> {
    
    /**
     * Adds the specified element to this list at the proper location
     * @param element - the element to be added to this list
     */
    public void add(T element);
}
