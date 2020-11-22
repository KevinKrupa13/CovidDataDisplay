package prj5;

import java.util.Comparator;

/**
 * SortByAlpha is our Comparator class
 * which helps sort by alphabetical order
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 */
public class SortByAlpha implements Comparator<Race> {

    /**
     * Compare method which compares the two inputs
     * alphabetically
     * 
     * @param o1
     *            First input
     * 
     * @param o2
     *            Second input
     * 
     * @return int value representating which one is larger
     */
    @Override
    public int compare(Race o1, Race o2) {
        String aa = o1.getRace();
        String bb = o2.getRace();
        return aa.compareTo(bb);
    }

}
