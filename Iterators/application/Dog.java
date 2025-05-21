package application;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: March 8, 2023
 * This class implements the Comparable interface, allowing it to compare two
 * dog objects by their age in an increasing order. Furthermore, it allows for
 * their String names to be tested for equality.
 */
public class Dog implements Comparable<Dog> {
    
    private String name; /* String instance variable that represents the name
    of the dog object */
    private int age; /* Integer instance variable that represents the age of
    the dog object */
    
    /**
     * Constructs Dog object
     * @param name, the name of the dog
     * @param age, the age of the dog
     */
    public Dog (String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Returns dogs name
     * @return name, the dog's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns dog's age
     * @return age, the dog's age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Returns a string containing dog's attributes
     * @return a string containing dog's attributes
     */
    public String toString() {
        return "{Name}: " + name + " {Age}: " + age;
    }
    
    /**
     * Compares the attributes of two dogs.
     * @param t, t Dog object
     * @return zero when the object before the dot operator has the same age
     * as the parameter object. Returns -1 when this object's age is smaller
     * then the age in the parameter object, otherwise it returns 1.
     */
    @Override
    public int compareTo(Dog t) {
        if (age == t.getAge()) {
            return 0;
        } else if (age < t.getAge()) {
            return -1;
        } else {
            return 1;
        }
    }
    
    /**
     * Compares two dogs for equality.
     * @param t, t Dog object
     * @return true when the attributes of the object before the dot operator
     * and the attributes of the parameter objects are the same.
     */
    @Override
    public boolean equals(Object t) {
        Dog d = (Dog) t;
        
        if (t == null || !(t instanceof Dog)) {
            return false;
        }
       
        return this.name.equals(d.name) && this.age == d.age;
    }
    
}
