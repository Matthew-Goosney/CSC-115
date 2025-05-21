package collections;

import exceptions.EmptyCollectionException;
import exceptions.ElementNotFoundException;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: April 10, 2023
 * A class that implements the BinaryTreeADT and BinarySearchADT and allows 
 * for the tree to be properly manipulated and iterable.
 */
public class BinarySearchTree<T extends Comparable<T>> 
        implements BinaryTreeADT<T>, BinarySearchADT<T> {

    private ArrayList<T> tree; /* Variable that represents a binary tree */
    
    public BinarySearchTree() {
        tree = new ArrayList<T>();
    }
    
    public BinarySearchTree(T element) {
        tree = new ArrayList<T>();
        tree.add(element);
    }
    
    /**
     * A method that returns the root element of the tree
     * @return - returns the root of the tree
     * @throws EmptyCollectionException 
     */
    @Override
    public T getRootElement() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty collection!");
        }
        return tree.get(0);
    }

    /**
     * A method that returns true or false to determine if the tree is empty
     * @return - returns true or false to determine if the tree is empty
     */
    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    /**
     * A method that returns the size of the tree
     * @return - returns the size of the tree
     */
    @Override
    public int size() {
       return tree.size();
    }

    /**
     * A method that determines whether the tree contains a particular element
     * @param targetElement - the target element in the tree
     * @return 
     */
    @Override
    public boolean contains(T targetElement) {
        try {
        find(targetElement);
        return true;
        } catch (EmptyCollectionException | ElementNotFoundException ex) {
            return false;
        }
    }

    /**
     * A method that finds a particular element within the tree
     * @param targetElement - the target element in the tree
     * @return - returns the index of the element you wish to find
     * @throws EmptyCollectionException
     * @throws exceptions.ElementNotFoundException
     */
    @Override
    public T find(T targetElement) throws EmptyCollectionException, ElementNotFoundException {
        if (tree.isEmpty()) {
            throw new EmptyCollectionException("Empty collection!");
        }
        int index = findSubNode(0, targetElement);
        if (index == -1) {
            throw new ElementNotFoundException("Element not found!");
        }
        return tree.get(index);
    }
    
    /**
     * A method that finds a subnode of a parent element
     * @param index - index variable that represents the index of a subnode
     * @param targetElement - target element that equals the index
     * @return 
     */
    public int findSubNode(int index, T targetElement) {
        if (index >= tree.size()) {
            return -1;
        } else if (targetElement.equals(tree.get(index))) {
            return index;
        } else if (targetElement.compareTo(tree.get(index)) < 0) {
            return findSubNode(2 * index + 1, targetElement);
        } else {
            return findSubNode(2 * index + 2, targetElement);
        }
    }
    
   /**  
    * Performs an in-order traversal on this binary tree by calling an 
    * overloaded, recursive in-order method that starts with the root. 
    * @return  - returns an iterator over the elements of this binary tree
    */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayList<T> list = new ArrayList<T>();
        inOrder(0, list);
        return list.iterator();
    }

    /**
     * A sub method used to for an in-order traversal of the binary tree
     * @param node - variable that represents a node of the tree
     * @param list - variable that represents the entire tree
     */
    public void inOrder(int node, ArrayList<T> list) {
        if (node < tree.size() && tree.get(node) != null) {
            inOrder(getLeftChild(node), list);
            list.add(tree.get(node));
            inOrder(getRightChild(node), list);
        }
    }
    
   /**  
    * Performs a pre-order traversal on this binary tree by calling an 
    * overloaded, recursive pre-order method that starts with the root. 
    * @return - returns an iterator over the elements of this binary tree
    */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayList<T> list = new ArrayList<T>();
        preOrder(0, list);
        return list.iterator();
    }
    
    /**
     * A sub method used to for a pre-order traversal of the binary tree
     * @param node - variable that represents a node of the tree
     * @param list - variable that represents the entire tree
     */
    public void preOrder(int node, ArrayList<T> list) {
        if (node < tree.size() && tree.get(node) != null) {
            list.add(tree.get(node));
            preOrder(getLeftChild(node), list);
            preOrder(getRightChild(node), list);
        }
    }

       /**  
    * Performs a post-order traversal on this binary tree by calling an 
    * overloaded, recursive post-order method that starts with the root. 
    * @return - returns an iterator over the elements of this binary tree
    */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayList<T> list = new ArrayList<T>();
        postOrder(0, list);
        return list.iterator();
    }
    
    /**
     * A sub method used to for a post-order traversal of the binary tree
     * @param node - variable that represents a node of the tree
     * @param list - variable that represents the entire tree
     */
    public void postOrder(int node, ArrayList<T> list) {
        if (node < tree.size() && tree.get(node) != null) {
            postOrder(getLeftChild(node), list);
            postOrder(getRightChild(node), list);
            list.add(tree.get(node));
        }
    }
    

    /**  
    * Performs a level-order traversal on the binary tree, using a queue.
    * @return - returns an iterator over the elements of this binary tree
    */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayList<T> list = new ArrayList<T>();
        
        if(!isEmpty()) {
            list.add(tree.get(0));
            int index = 0;
            
            while (index < size()) {
                int leftIndex = (index * 2) + 1;
                int rightIndex = (index * 2) + 2;
                
                if(leftIndex < size()) {
                    list.add(tree.get(leftIndex));
                }
                
                if(rightIndex < size()) {
                    list.add(tree.get(rightIndex));
                }
                
                index++;
            }
        }
        return list.iterator();
    }

    /** 
    * Adds the specified element to the proper location in this tree. 
    * @param element  the element to be added to this tree
    */
    @Override
    public void add(T element) {
       if (tree.isEmpty()) {
           tree.add(element);
       } else {
           addToSubTree(0, element);
       }
    }
    
    /**
     * A method that adds an element to a parent index
     * @param index - variable that represents the index of the element to 
     * be added
     * @param element - variable that represents an element in the tree to
     * be added
     */
    public void addToSubTree(int index, T element) {
        if (element.compareTo(tree.get(index)) < 0) {
            int leftChild = 2 * index + 1;
            if (leftChild >= tree.size()) {
                tree.add(leftChild, element);
            } else {
                addToSubTree(leftChild, element);
            }
        } else {
            int rightChild = 2 * index + 2;
            if (rightChild >= tree.size()) {
                tree.add(rightChild, element);
            } else {
                addToSubTree(rightChild, element);
            }
        }
    }
    
    /**
     * A method that represents the computational strategy for any 
     * element in position n of the array
     * @param node - represents the parent node
     * @return - returns the left child of a particular parent node
     */
    public int getLeftChild(int node) {
        return (node * 2) + 1;
    }
    
    /**
     * A method that represents the computational strategy for any
     * element in position n of the array
     * @param node - represents the parent node
     * @return - returns the right child of a particular parent node
     */
    public int getRightChild(int node) {
        return (node * 2) + 2;
    }

   /** 
    * Returns a reference to the smallest element in this tree. 
    * @return - returns a reference to the smallest element in this tree
    * @throws EmptyCollectionException when tree is empty
    */ 
    @Override
    public T findMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty collection!");
        }
        int index = 0;
        while (2 * index +1 < tree.size()) {
            index = 2 * index + 1;
        }
        return tree.get(index);
    }

    /** 
    * Returns a reference to the largest element in this tree. 
    * @return - returns a reference to the largest element in this tree
    * @throws EmptyCollectionException when tree is empty
    */
    @Override
    public T findMax() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty collection!");
        }
        int index = 0;
        while (2 * index + 2 < tree.size()) {
            index = 2 * index + 2;
        }
        return tree.get(index);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Iterator<T> iter = iteratorLevelOrder();
        while (iter.hasNext()) {
            result.append(iter.next()).append(" ");
        }
        return result.toString().trim();
    }
    
    
}
