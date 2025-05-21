package application;

import collections.DoubleOrderedList;
import exceptions.*;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: March 8, 2023 
 * A class that tests the Dog class by creating dog objects, as well as 
 * by testing with the use of an Iterator object.
 */
public class OrderedListTest2 {

    /**
     *
     * @param args
     * @throws EmptyCollectionException
     */
    public static void main(String[] args) throws EmptyCollectionException {
        DoubleOrderedList<Dog> list = new DoubleOrderedList();

        list.add(new Dog("Fido", 14));
        list.add(new Dog("Mumbo", 7));
        list.add(new Dog("JimillyBillyBob", 4));
        list.add(new Dog("Bonkas", 1));
        list.add(new Dog("Bonkas", 3));

        Dog d = list.first();
        System.out.println(list.toString());
        System.out.println("[Contains Fido?]: " + list.contains(d));
        System.out.println("[Empty?]: " + list.isEmpty());
        System.out.println("[List Size]: " + list.size());

        try {
            Dog test = new Dog("Bonkas", 1);
            Dog c = list.last();
            list.remove(test);
            list.remove(c);
        } catch (ElementNotFoundException | EmptyCollectionException e) {
            System.out.println(e.getMessage() + "");
        }
        System.out.println(list.toString());
        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        //Iterator testing
        Iterator<Dog> icarus = list.iterator();
        while (icarus.hasNext()) {
            System.out.println(icarus.next());
        }
        System.out.println(list.toStringx2());
        
        
        try {
        icarus.next();
        } catch (NoSuchElementException e) {
            System.out.println("[Elements Remaining After Iterator]: " + e.getMessage());
        }
    }
}
