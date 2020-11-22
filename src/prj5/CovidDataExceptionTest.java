package prj5;

/**
 * CovidDataExceptionTest is the
 * test class for the CovidDataException class
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 */
public class CovidDataExceptionTest extends student.TestCase {

    /**
     * Tests the CovidDataException constructor
     */
    public void testCovidDataException() {
        Exception exception = null;
        try {
            throw new CovidDataException("Data Exception");
        }
        catch (CovidDataException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception.getMessage().equals("Data Exception"));
    }

}
