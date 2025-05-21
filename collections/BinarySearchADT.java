/**
 * BinarySearchTreeADT defines the interface to a binary search tree.
 */

package collections;
import exceptions.EmptyCollectionException;

public interface BinarySearchADT<T> extends BinaryTreeADT<T> 
{
    /** 
    * Adds the specified element to the proper location in this tree. 
    *
    * @param element  the element to be added to this tree
    */
   public void add (T element);

 
   /** 
    * Returns a reference to the smallest element in this tree. 
    * 
    * @return  a reference to the smallest element in this tree
    * @throws EmptyCollectionException when tree is empty
    */ 
   public T findMin() throws EmptyCollectionException;

   /** 
    * Returns a reference to the largest element in this tree. 
    * 
    * @return  a reference to the largest element in this tree
    * @throws EmptyCollectionException when tree is empty
    */
   public T findMax() throws EmptyCollectionException;

}

