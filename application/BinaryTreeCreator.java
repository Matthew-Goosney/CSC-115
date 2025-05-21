package application;

import java.util.Iterator;
import exceptions.*;
import collections.BinarySearchTree;

public class BinaryTreeCreator {

  public static void main(String[] args) throws EmptyCollectionException {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.add(4);
    tree.add(2);
    tree.add(6);
    tree.add(1);
    tree.add(3);
    tree.add(5);
    tree.add(7);

    System.out.println("\n LevelOrder \n");
    Iterator<Integer> treeIterator = tree.iteratorLevelOrder();
    while (treeIterator.hasNext()) {
      System.out.println("Element = " + treeIterator.next());
    }
    System.out.println("\n InOrder \n");
    treeIterator = tree.iteratorInOrder();

    while (treeIterator.hasNext()) {
      System.out.println("Element = " + treeIterator.next());
    }
    System.out.println("\n PreOrder \n");
    treeIterator = tree.iteratorPreOrder();

    while (treeIterator.hasNext()) {
      System.out.println("Element = " + treeIterator.next());
    }
    System.out.println("\n PostOrder \n");
    treeIterator = tree.iteratorPostOrder();

    while (treeIterator.hasNext()) {
      System.out.println("Element = " + treeIterator.next());
    }
    System.out.println(tree.toString());

    System.out.println("Is 5 in the tree? " + tree.contains(5));
    System.out.println("Is 7 in the tree? " + tree.contains(7));
    try {
      System.out.println("find element: " + tree.find(2));

    } catch (ElementNotFoundException e) {
      System.out.println(e.getMessage());
    }
    System.out.println("size: " + tree.size());
    System.out.println("smallest: " + tree.findMin());
    System.out.println("max: " + tree.findMax());
   
  }
}