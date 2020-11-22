/**
 * 
 */
package prj5;

/**
 * State class creates a state object
 * that stores a list of races for each
 * different state
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 */
public class State {

    private String name;
    private LinkedList<Race> race;

    /**
     * Index for white race
     */
    public static final int WHITE = 0;

    /**
     * Index for black race
     */
    public static final int BLACK = 1;

    /**
     * index for Latinx race
     */
    public static final int LATINX = 2;

    /**
     * Index for Asian race
     */
    public static final int ASIAN = 3;

    /**
     * Index for Other race
     */
    public static final int OTHER = 4;

    /**
     * Constructor for the state class
     * 
     * @param name
     *            Name of the state
     * @param cases
     *            Integer array representing cases
     * @param deaths
     *            Integer array representing deaths
     */
    public State(String name, int[] cases, int[] deaths) {
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
