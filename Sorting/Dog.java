package goosney_lab5.sorting;

public class Dog implements Comparable<Dog> {
    
    private String name; /* String instance variable that represents the name
    of the dog object */
    private int weight; /* Integer instance variable that represents the age of
    the dog object */
    
    /**
     * Constructs Dog object
     * @param name, the name of the dog
     * @param weight, the weight of the dog
     */
    public Dog (String name, int weight) {
        this.name = name;
        this.weight = weight;
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
    public int getWeight() {
        return weight;
    }
    
    /**
     * Returns a string containing dog's attributes
     * @return a string containing dog's attributes
     */
    public String toString() {
        return "{Name}: " + name + " {Weight}: " + weight;
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
        if (weight == t.getWeight()) {
            return 0;
        } else if (weight < t.getWeight()) {
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
       
        return this.name.equals(d.name) && this.weight == d.weight;
    }
    
}