/**
 * BinaryTreeADT defines the interface to a binary tree data structure.
 */
package collections;
import exceptions.ElementNotFoundException;
import java.util.Iterator;
import exceptions.EmptyCollectionException;

public interface BinaryTreeADT<T> 
{
   /** 
    * Returns a reference to the root element 
    *
    * @return               a reference to the root
    * @throws EmptyCollectionException if the tree is empty
    */
   public T getRootElement() throws EmptyCollectionException;

   /** 
    * Returns true if this binary tree is empty and false otherwise.
    *
    * @return  true if this binary tree is empty
    */
   public boolean isEmpty();

   /** 
    * Returns the number of elements in this binary tree.
    *
    * @return  the integer number of elements in this tree
   */
   public int size();

   /** 
    * Returns true if the binary tree contains an element that matches
    * the specified element and false otherwise. 
   *
    * @param targetElement  the element being sought in the tree
    * @return               true if the tree contains the target element
    */
   public boolean contains (T targetElement);

   /** 
    * Returns a reference to the specified element if it is found in 
    * this binary tree.  Throws an exception if the specified element
    * is not found.
    *
    * @param targetElement  the element being sought in the tree
    * @return               a reference to the specified element
    * @throws ElementNotFoundException if an element is not found 
    */
   public T find (T targetElement) throws EmptyCollectionException, ElementNotFoundException;

   /**  
    * Returns the string representation of the binary tree.
    *
    * @return  a string representation of the binary tree
    */
   public String toString();
   
   /**  
    * Performs an inorder traversal on this binary tree by calling an 
    * overloaded, recursive inorder method that starts with the root. 
    *
    * @return  an iterator over the elements of this binary tree
    */
   public Iterator<T> iteratorInOrder();

   /**  
    * Performs a preorder traversal on this binary tree by calling an 
    * overloaded, recursive preorder method that starts with the root. 
    *
    * @return  an iterator over the elements of this binary tree
    */
   public Iterator<T> iteratorPreOrder();

   /**  
    * Performs a postorder traversal on this binary tree by calling an 
    * overloaded, recursive postorder method that starts with the root. 
    *
    * @return  an iterator over the elements of this binary tree
    */
   public Iterator<T> iteratorPostOrder();

   /**  
    * Performs a levelorder traversal on the binary tree, using a queue.
    *
    * @return  an iterator over the elements of this binary tree
    */
   public Iterator<T> iteratorLevelOrder();
   
}
