package prj5;

/**
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @version 11/21/20
 * @author Suha Dewan (suhad)
 * @version 11/21/20
 *
 */

public class StateTest extends student.TestCase {

    private State state;
    private LinkedList<Race> race;
    private int[] cases;
    private int[] deaths;
    
    /**
     * sets up tests
     */
    public void setUp() throws CovidDataException {
        race = new LinkedList<Race>();
        cases = new int[5];
        deaths = new int[5];
        cases[0] = 100;
        cases[1] = 90;
        cases[2] = 200;
        cases[3] = 300;
        cases[4] = 150;
        
        deaths[0] = 90;
        deaths[1] = 30;
        deaths[2] = 90;
        deaths[3] = 100;
        deaths[4] = 50;
        
        
            
        state = new State("CT", cases, deaths);
    }
    
    /**
     * tests getter methods
     * @throws CovidDataException
     */
    public void testGetters() throws CovidDataException {
        Race white = new Race("white", 100, 90);
        Race black = new Race("black", 90, 30);
        Race asian = new Race("asian", 200, 90);
        Race latinx = new Race("latinx", 300, 100);
        Race other = new Race("other", 150, 50);
        race.add(white);
        race.add(black);
        race.add(asian);
        race.add(latinx);
        race.add(other);
        assertEquals("CT", state.getName());
        assertEquals(race.toString(), state.getRace().toString());
    }
    
    /**
     * tests sort by alphabetical
     * @throws CovidDataException 
     */
    public void testSortAlpha() throws CovidDataException {
        Race white = new Race("white", 100, 90);
        Race black = new Race("black", 90, 30);
        Race asian = new Race("asian", 200, 90);
        Race latinx = new Race("latinx", 300, 100);
        Race other = new Race("other", 150, 50);
        state.sortByAlpha();
        assertEquals(asian, state.getRace().get(0));
        assertEquals(black, state.getRace().get(1));
        assertEquals(latinx, state.getRace().get(2));
        assertEquals(other, state.getRace().get(3));
        assertEquals(white, state.getRace().get(4));
    }
    
    /**
     * tests sort by CFR
     * @throws CovidDataException 
     */
    public void testSortCFR() throws CovidDataException {
        Race white = new Race("white", 100, 90);
        Race black = new Race("black", 90, 30);
        Race asian = new Race("asian", 200, 90);
        Race latinx = new Race("latinx", 300, 100);
        Race other = new Race("other", 150, 50);
        state.sortByCFR();
        assertEquals(white, state.getRace().get(0));
        assertEquals(asian, state.getRace().get(1));
        assertEquals(black, state.getRace().get(2));
        assertEquals(latinx, state.getRace().get(3));
        assertEquals(other, state.getRace().get(4));
    }
}
