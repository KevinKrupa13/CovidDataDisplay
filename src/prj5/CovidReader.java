package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CovidReader {

    private LinkedList<Race> races;
    private State[] states;

    public CovidReader(String fileName)
        throws FileNotFoundException,
        CovidDataException {
        states = stateReader(fileName);
        //races = raceReader(fileName);
    }


    private LinkedList<Race> raceReader(String fileName)
        throws FileNotFoundException {
        LinkedList<Race> temp = new LinkedList<Race>();
        Scanner file = new Scanner(new File(fileName));

        return temp;
    }


    private State[] stateReader(String fileName)
        throws FileNotFoundException,
        CovidDataException {
        State[] temp = new State[6];
        Scanner file = new Scanner(new File(fileName));
        
        String string = file.next();
        String stateSt = string.substring(0, 5);
        State state = null;
        LinkedList<Race> race = null;
        
        for (int i = 0; i < temp.length; i++) {
            if (!file.hasNext()) {
                throw new CovidDataException("Not enough planets"); 
            }
            string = file.next();
            stateSt = string.substring(0, 2);
            
            
            state = new State(stateSt, race);
            temp[i] = state;
        }

        return temp;
    }

}
