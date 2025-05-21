package exceptions;
/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: March 8, 2023
 * A custom exception class that is called to whenever the collection in the
 * application is found to be empty
 */
public class EmptyCollectionException extends Exception {

    /**
     * A constructor method that creates a specific exception to be sent in the application
     * if the container is found to be empty
     * @param invalid - String parameter that is called to in order to notify
     * whenever an invalidity is present
     */
    public EmptyCollectionException(String invalid) {
        super("Empty queue!");
    }

    /**
     * Empty constructor method that validates the exception
     */
    public EmptyCollectionException() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
