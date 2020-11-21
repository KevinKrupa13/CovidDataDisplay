package prj5;

public class StateTest extends student.TestCase {

    private State state;
    private LinkedList<Race> race;
    private int[] cases;
    private int[] deaths;

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
     * 
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

}
