package application;

import collections.DoubleOrderedList;
import exceptions.*;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: March 8, 2023
 * A test class that determines whether the add and remove functions of the
 * DoubleOrderedList are implemented correctly.
 */
public class OrderedListTest {
    
    /**
     * Main method that creates a new list of strings to be manipulated/test
     * the methods from the various implemented files.
     * @param args
     * @throws EmptyCollectionException 
     */
    public static void main(String[] args) throws EmptyCollectionException {
        DoubleOrderedList<String> list = new DoubleOrderedList();
        
        //List of String elements
        list.add("Hemmingway");
        list.add("Oscar W.");
        list.add("Hippopotomas Lovecraft");
        list.add("Miriam");
        list.add("Phobos");
        list.add("Deimos");
        list.add("Aaaaaafoo");
        
        System.out.println(list.toString());
        System.out.println("[First]: " + list.first() + " [Last]: " + 
                list.last());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
        
        
        //Testing the remove methods
        try {
        list.remove("Hemmingway");
        list.removeFirst();
        list.removeLast();
        } catch (ElementNotFoundException | EmptyCollectionException e) {
            System.out.println(e.getMessage() + "");
        }
        System.out.println(list.toString());
        
        //Testing method contains(), isEmpty(), and size()
        System.out.println("[Size]: " + list.size());
        System.out.println("[Contains Deimos?]: " + 
                list.contains("Deimos"));
        System.out.println("[Contains Hemmingway?]: " + 
                list.contains("Hemmingway"));
        System.out.println("[Empty list?]: " + list.isEmpty());
        
        /*
        try {
            list.remove("Hamsterdam");
        } catch (ElementNotFoundException | EmptyCollectionException e) {
            System.out.println(e.getMessage() + "");
        }
        list.removeFirst();
        System.out.println(list.toString());
     */   
    }
}
