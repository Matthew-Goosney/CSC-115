package exception;

/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: February 1st, 2023
 * A custom exception class that is called to whenever the container in the
 * ArrayContainer class is found to be empty
 */
public class EmptyContainerException extends Exception {

    /**
     * A constructor method that creates a specific exception to be sent in the application
     * if the container is found to be empty
     * @param invalid - String parameter that is called to in order to notify
     * whenever an invalidity is present
     */
    public EmptyContainerException(String invalid) {
        super(invalid);
    }

    /**
     * Empty constructor method that validates the exception
     */
    public EmptyContainerException() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
