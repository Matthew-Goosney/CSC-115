package exceptions;
/**
 * @author: Matthew Goosney, C0505342 
 * Section: 001B 
 * Date: February 26, 2023
 * A custom exception class that is called to whenever the queue in the
 * application is found to be empty
 */
public class EmptyQueueException extends Exception {

    /**
     * A constructor method that creates a specific exception to be sent in the application
     * if the container is found to be empty
     * @param invalid - String parameter that is called to in order to notify
     * whenever an invalidity is present
     */
    public EmptyQueueException(String invalid) {
        super("Empty queue!");
    }

    /**
     * Empty constructor method that validates the exception
     */
    public EmptyQueueException() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
