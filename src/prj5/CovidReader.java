package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CovidReader {

    private LinkedList<Race> races;
    private State[] states;

    public CovidReader(String fileName) throws FileNotFoundException {
        races = raceReader(fileName);
        states = stateReader(fileName);
    }


    private LinkedList<Race> raceReader(String fileName)
        throws FileNotFoundException {
        LinkedList<Race> temp = new LinkedList<Race>();
        Scanner file = new Scanner(new File(fileName));
    }


    private State[] stateReader(String fileName) throws FileNotFoundException {
        State[] temp = new State[6];
        Scanner file = new Scanner(new File(fileName));
    }

}
