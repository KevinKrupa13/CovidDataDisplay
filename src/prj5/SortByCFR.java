package prj5;

import java.util.Comparator;

public class SortByCFR implements Comparator<Race> {

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
