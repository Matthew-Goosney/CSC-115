package goosney_lab5.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: March 28 - April 1, 2023
 * A class that creates an array of integers and dog objects and manipulates
 * them in a variety of ways. It sorts them by weight and name in ascending
 * order, and sorts it by descending order.
 */
public class Lab5 {

    /**
     * Main method that contains an array of integers and of dog objects.
     * @param args 
     */
    public static void main(String[] args) {

        Integer[] array = {10, 15, 20, 43, 3, 89, 69, 500, 1};
        findMinMax(array);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

        ArrayList<Dog> list = new ArrayList<Dog>();
        list.add(new Dog("Oppa", 50));
        list.add(new Dog("Buddy", 75));
        list.add(new Dog("Rango", 500));
        list.add(new Dog("Ringo", 102));
        list.add(new Dog("Shrimp", 30));
        list.add(new Dog("Charlie", 250));
        list.add(new Dog("Bo", 17));

        sortDogsByWeight(list);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
        sortDogsByName(list);

        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Reverse Sort: ");
        displayDogsReverse(list);
    }

    //Task 1
    /**
     * A method that receives an array of integers and displays the maximum
     * and minimum value in the array.
     * @param array - array of integers
     */
    private static void findMinMax(Integer[] array) {
        Integer max = Collections.max(Arrays.asList(array));
        Integer min = Collections.min(Arrays.asList(array));
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }

    //Task 2
    /**
     * A method that receives a list of dog objects and sorts dogs by weight
     * in ascending order.
     * @param <T> - Generic type parameter.
     * @param list - array that contains a list of dog objects to be
     * manipulated.
     */
    public static <T extends Comparable<Dog>> void sortDogsByWeight(ArrayList<Dog> list) {
        Collections.sort(list);
        System.out.println("Sorted by Weight: ");
        for (Dog dog : list) {
            System.out.println(dog.toString());
        }
    }

    //Task 3
    /**
     * A method that receives a list of dog objects and sorts dogs by name
     * in ascending order.
     * @param <T> - Generic type parameter.
     * @param list - array that contains a list of dog objects to be
     * manipulated.
     */
    public static <T extends Comparable<Dog>> void sortDogsByName(ArrayList<Dog> list) {
        Comparator<Dog> name = new Comparator<Dog>() {
            @Override
            public int compare(Dog d1, Dog d2) {
                return d1.getName().compareTo(d2.getName());
            }
        };
        Collections.sort(list, name);
        System.out.println("Sorted by Name: ");
        for (Dog dog : list) {
            System.out.println(dog.toString());
        }
    }

    //Task 4
    /**
     * Recursive method that receives a list of dogs and recursively displays
     * the list backwards.
     * @param list - array that contains a list of dog objects to be
     * manipulated.
     */
    public static void displayDogsReverse(ArrayList<Dog> list) {
        if (list.isEmpty()) {
            return;
        }

        Dog reverseDog = list.remove(list.size() - 1);
        System.out.println("[Name]: " + reverseDog.getName()
                + " " + "[Weight]: " + reverseDog.getWeight());
        displayDogsReverse(list);
    }
}
