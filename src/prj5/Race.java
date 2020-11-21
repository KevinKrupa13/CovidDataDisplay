package prj5;

import java.util.Comparator;

public class Race implements Comparator<Race> {

    private String race;
    private long numberOfDeaths;
    private long numberOfCases;

    public Race(String race, long numberOfCases, long numberOfDeaths)
        throws CovidDataException {
        if (numberOfCases < numberOfDeaths) {
            throw new CovidDataException("Too many deaths");
        }

        this.race = race;
        this.numberOfCases = numberOfCases;
        this.numberOfDeaths = numberOfDeaths;
    }


    public String getRace() {
        return this.race;
    }


    public long getDeaths() {
        return this.numberOfDeaths;
    }


    public long getCases() {
        return this.numberOfCases;
    }


    public double calculateCFR() {
        return (this.numberOfDeaths / this.numberOfCases) * 100;
    }


    public boolean equals(Object entry) {
        if (entry == null) {
            return false;
        }

        if (entry == this) {
            return true;
        }

        if (this.getClass() == entry.getClass()) {
            Race temp = ((Race)entry);

            return (this.race.equals(temp.getRace())
                && this.numberOfCases == temp.getCases()
                && this.numberOfDeaths == temp.getDeaths());
        }

        return false;
    }


    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append(this.race + " ");
        string.append("Cases: " + this.numberOfCases + " ");
        string.append("Deaths: " + this.numberOfDeaths);

        return string.toString();
    }

    /**
     * A new comparator to compare songs by their title
     */
    public static final Comparator<Race> COMPARE_BY_RACE =
        new Comparator<Race>() {
            /**
             * Compare race 1 and race 2
             * 
             * @param o1
             *            the first race
             * @param o2
             *            the second race
             * @return an int based on the race data comparison
             */
            @Override
            public int compare(Race o1, Race o2) {
                return o1.getRace().compareTo(o2.getRace());
            }
        };

    /**
     * A new comparator to compare songs by their title
     */
    public static final Comparator<Race> COMPARE_BY_CFR =
        new Comparator<Race>() {
            /**
             * Compare cfr 1 and cfr 2
             * 
             * @param o1
             *            the first cfr
             * @param o2
             *            the second cfr
             * @return an int based on the race data comparison
             */
            @Override
            public int compare(Race o1, Race o2) {
                if (o1.calculateCFR() < o2.calculateCFR()) {
                    return -1;
                }
                else if (o1.calculateCFR() > o2.calculateCFR()) {
                    return 1;
                }
                return 0;
            }
        };

    @Override
    public int compare(Race o1, Race o2) {
        return o1.getRace().compareTo(o2.getRace());
    }

}
