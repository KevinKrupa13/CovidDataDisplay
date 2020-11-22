package prj5;

/**
 * CovidDataException class is our own
 * exception that is thrown if the data
 * did not meet our requirments
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 *
 */
@SuppressWarnings("serial")
public class CovidDataException extends Exception {

    /**
     * Constructor for the exception
     * 
     * @param message
     *            What message the exception has
     */
    public CovidDataException(String message) {
        super(message);
    }

}
