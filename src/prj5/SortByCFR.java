package prj5;

import java.util.Comparator;

/**
 * SortByCFR is our Comparator class
 * which helps sort by numerical order
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 */
public class SortByCFR implements Comparator<Race> {

    /**
     * Compare method which compares the two inputs
     * numerically
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
        Double aa = o1.calculateCFR();
        Double bb = o2.calculateCFR();

        if (aa > bb) {
            return -1;
        }
        else if (aa.equals(bb)) {
            return o1.getRace().compareTo(o2.getRace());
        }
        return 1;
    }

}
