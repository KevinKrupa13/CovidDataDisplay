package prj5;

/**
 * RaceTest is the test class
 * for the Race class
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 */
public class RaceTest extends student.TestCase {

    private Race race;

    /**
     * Setup for the test class
     */
    public void setUp() {
        race = new Race("Race", 10000, 5000);
    }


    /**
     * Tsts the getRace() method
     */
    public void testGetRace() {
        assertTrue(race.getRace().equals("Race"));
    }


    /**
     * Tests the getDeaths() method
     */
    public void testGetDeaths() {
        assertEquals(race.getDeaths(), 5000);
    }


    /**
     * Tests the getCases() method
     */
    public void testGetCases() {
        assertEquals(race.getCases(), 10000);
    }


    /**
     * Tests the calculateCFR() method
     */
    public void testCalculateCFR() {
        assertEquals(race.calculateCFR(), 0.0, 50.0);

        Race difCases;
        Race difDeaths;

        difCases = new Race("Race", -1, -1);
        difDeaths = new Race("Race", 10000, -1);

        assertEquals(difCases.calculateCFR(), -1.0, 0.0);
        assertEquals(difDeaths.calculateCFR(), -1.0, 0.0);

        Race other;
        other = new Race("Race", -1, 728);
        assertEquals(other.calculateCFR(), -1.0, 0.0);

    }


    /**
     * Tests the equals() method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {
        Race same = race;
        Race equals = new Race("Race", 10000, 5000);

        Race difName = new Race("Name", 10000, 5000);
        Race difCases = new Race("Race", 9000, 5000);
        Race difDeaths = new Race("Race", 10000, 4000);

        Race nullRace = null;

        String difClass = "Kevin";

        assertTrue(race.equals(same));
        assertTrue(race.equals(equals));

        assertFalse(race.equals(difName));
        assertFalse(race.equals(difCases));
        assertFalse(race.equals(difDeaths));

        assertFalse(race.equals(nullRace));

        assertFalse(race.equals(difClass));

    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        assertTrue(race.toString().equals("Race Cases: 10000 Deaths: 5000"));
    }

}
