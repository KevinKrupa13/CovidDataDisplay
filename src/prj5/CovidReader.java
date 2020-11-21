package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CovidReader {

    private LinkedList<State> states;

    public CovidReader(String fileName)
        throws FileNotFoundException,
        CovidDataException {
        states = new LinkedList<State>();
        dataReader(fileName);
        // races = raceReader(fileName);
    }


    private void dataReader(String filename)
        throws FileNotFoundException,
        CovidDataException {
        File input = new File(filename);
        Scanner scan = new Scanner(input);
        scan.nextLine();
        while (scan.hasNextLine()) {
            String a = scan.nextLine();
            String[] data = a.split(",", 11);
            String state = data[0];
            for (int i = 1; i < data.length; i++) {
                System.out.println(data[i]);
            }
            String[] casesStr = { "", "", "", "", "" };
            String[] deathsStr = { "", "", "", "", "" };
            for (int i = 1; i < 6; i++) {
                casesStr[i - 1] = data[i];
            }
            for (int i = 6; i < 11; i++) {
                deathsStr[i % 6] = data[i];
            }
            int[] deaths = parseInt(deathsStr);
            int[] cases = parseInt(casesStr);
            State st = new State(state, cases, deaths);
            states.add(st);
            System.out.println(state);
            System.out.println(states);
        }
        scan.close();
    }


    private int[] parseInt(String[] data) {
        int[] arr = { 0, 0, 0, 0, 0 };
        for (int i = 0; i < data.length; i++) {
            try {
                arr[i] = Integer.parseInt(data[i]);
            }
            catch (Exception exception) {
                arr[i] = -1;
            }
        }
        return arr;
    }


    public LinkedList<State> getStates() {
        return states;
    }

// private LinkedList<Race> raceReader(String fileName)
// throws FileNotFoundException {
// LinkedList<Race> temp = new LinkedList<Race>();
// Scanner file = new Scanner(new File(fileName));
//
// return temp;
// }
//
//
// private State[] stateReader(String fileName)
// throws FileNotFoundException,
// CovidDataException {
// State[] temp = new State[6];
// Scanner file = new Scanner(new File(fileName));
//
// String string = file.next();
// String stateSt = string.substring(0, 5);
// State state = null;
// LinkedList<Race> race = null;
//
// for (int i = 0; i < temp.length; i++) {
// if (!file.hasNext()) {
// throw new CovidDataException("Not enough planets");
// }
// string = file.next();
// stateSt = string.substring(0, 2);
//
//
// state = new State(stateSt, race);
// temp[i] = state;
// }
//
// return temp;
// }

}
