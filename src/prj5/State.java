/**
 * 
 */
package prj5;

/**
 * @author Kevin Krupa (kevinkrupa13)
 * @version 11/21/20
 * @author Suha Dewan (suhad)
 * @version 11/21/20
 *
 */
public class State {

    private String name;
    private LinkedList<Race> race;

    public static final int WHITE = 0;
    public static final int BLACK = 1;
    public static final int LATINX = 2;
    public static final int ASIAN = 3;
    public static final int OTHER = 4;

    public State(String name, int[] cases, int[] deaths)
        throws CovidDataException {
        this.name = name.replaceAll("\"", "");
        race = new LinkedList<Race>();
        race.add(new Race("white", new Long(cases[WHITE]), new Long(
            deaths[WHITE])));
        race.add(new Race("black", new Long(cases[BLACK]), new Long(
            deaths[BLACK])));
        race.add(new Race("latinx", new Long(cases[LATINX]), new Long(
            deaths[LATINX])));
        race.add(new Race("asian", new Long(cases[ASIAN]), new Long(
            deaths[ASIAN])));
        race.add(new Race("other", new Long(cases[OTHER]), new Long(
            deaths[OTHER])));
    }


    /**
     * Gets the name of the state
     * 
     * @return name of state
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the states race LinkedList
     * 
     * @return LinkedList of type race
     */
    public LinkedList<Race> getRace() {
        return race;
    }


    /**
     * method that sorts by alphabetical
     * 
     * @return sorted list
     */
    public LinkedList<Race> sortByAlpha() {
        race.insertionSort(new SortByAlpha());
        return race;
    }


    /**
     * method that sorts by CFR
     * 
     * @return sorted list
     */
    public LinkedList<Race> sortByCFR() {
        race.insertionSort(new SortByCFR());
        return race;
    }

}
