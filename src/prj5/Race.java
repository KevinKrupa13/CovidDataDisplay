package prj5;

/**
 * Race class creates an object of type race
 * that has a name and a number of deaths/cases
 * stored with it
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 */
public class Race {

    private String name;
    private long numberOfDeaths;
    private long numberOfCases;

    /**
     * Constructor for the race class
     * 
     * @param race
     *            Name of the race
     * @param numberOfCases
     *            Number of cases that race has
     * @param numberOfDeaths
     *            Number of deatsh that race has
     */
    public Race(String race, long numberOfCases, long numberOfDeaths) {
        this.name = race;
        this.numberOfCases = numberOfCases;
        this.numberOfDeaths = numberOfDeaths;
    }


    /**
     * Getter method for race name
     * 
     * @return name of the race
     */
    public String getRace() {
        return this.name;
    }


    /**
     * Getter method for the number of deaths
     * 
     * @return the number of deaths for the race
     */
    public long getDeaths() {
        return this.numberOfDeaths;
    }


    /**
     * Getter method for the number of cases
     * 
     * @return the number of cases for the race
     */
    public long getCases() {
        return this.numberOfCases;
    }


    /**
     * Calculates the CFR value based off the number of
     * cases and deaths
     * 
     * If any value is -1.0 then the CFR value is -1.0
     * 
     * @return double CFR value
     */
    public double calculateCFR() {
        if (numberOfDeaths == -1 || numberOfCases == -1) {
            return -1;
        }
        return Math.round(((new Double(getDeaths()) / new Double(getCases()))
            * 100) * 10) / 10.0;
    }


    /**
     * Checks to see if this object is equal to the
     * passed object
     * 
     * @param entry
     *            Entry you are checking
     * 
     * @return true if they are equal
     */
    public boolean equals(Object entry) {
        if (entry == null) {
            return false;
        }

        if (entry == this) {
            return true;
        }

        if (this.getClass() == entry.getClass()) {
            Race temp = ((Race)entry);

            return (this.name.equals(temp.getRace())
                && this.numberOfCases == temp.getCases()
                && this.numberOfDeaths == temp.getDeaths());
        }

        return false;
    }


    /**
     * To string method which writes this object
     * in a string representation
     * 
     * "RaceName Cases: # Deaths: #"
     * 
     * @return string representation
     */
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append(this.name + " ");
        string.append("Cases: " + this.numberOfCases + " ");
        string.append("Deaths: " + this.numberOfDeaths);

        return string.toString();
    }

}
