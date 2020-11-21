package prj5;

import java.util.Comparator;

public class SortByAlpha implements Comparator<Race> {

    @Override
    public int compare(Race o1, Race o2) {
        String aa = o1.getRace();
        String bb = o2.getRace();
        return aa.compareTo(bb);
    }
    
    

}
