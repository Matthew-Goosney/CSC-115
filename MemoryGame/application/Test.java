/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.NoSuchElementException;
import container_adt.*;
import exception.*;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: February 1st, 2023
 * A test class that is to be used as an application to test whether the 
 * container/array can be manipulated correctly (it determines whether the
 * code fragments are correct or incorrect)
 */
public class Test {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayContainer<String> c = new ArrayContainer<String>(4);
    c.add("a");
    c.add("b");
    c.add("c");
    c.add("d");
    c.add("e");

    System.out.println("[Untouched Array] \n" + c.toString());
    try {
      c.remove("a");
    } catch (EmptyContainerException | NoSuchElementException ex) {
      System.out.println(ex.getMessage());
    }
    System.out.println("[Removed Element Array] \n" + c.toString());
    
    try {
      c.removeRandom();
    } catch (EmptyContainerException ex) {
      System.out.println(ex.getMessage());
    }
    System.out.println("[Removed Random Element Array] \n" + c.toString());
    
    System.out.println("- - - - - - - - - - - - - - - - - - - - -");
    System.out.println("[Does the array contain "
            + "element 'D']: " + c.contains("d"));
    System.out.println("[Is the array empty?]: " + c.isEmpty());
    System.out.println("[Maximum Array Size]: " + c.maxSize());
    System.out.println("[Number of Elements]: " + c.size());
    System.out.println("- - - - - - - - - - - - - - - - - - - - - \n");
    c.clear();
    c.toString();
    System.out.println("[Cleared Array]");
  }
}
