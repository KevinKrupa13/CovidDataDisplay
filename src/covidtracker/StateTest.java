package covidtracker;

public class StateTest extends student.TestCase {

    private State state;
    private LinkedList<Race> race;
    
    public void setUp() {
        race = new LinkedList<Race>();
        
        state = new State("CT", race);
    }
    
    public void testGetters() {
        assertTrue(state.getName().equals("CT"));
        assertSame(state.getRace(), race);
    }
    
}
