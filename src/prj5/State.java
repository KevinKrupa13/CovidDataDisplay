/**
 * 
 */
package prj5;

/**
 * @author suhad
 *
 */
public class State {
    
    private String name;
    private LinkedList<Race> race;
    
    public State(String name, LinkedList<Race> race) {
        this.name = name;
        this.race = race;
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

}
