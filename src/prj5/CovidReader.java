package prj5;

/**
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @version 11/21/20
 * @author Suha Dewan (suhad)
 * @version 11/21/20
 *
 */

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
//            for (int i = 0; i < data.length; i++) {
//                System.out.print(data[i]);
//            }
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
        }
        
        printer();
        
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
    
    private void printer() {
        State state = null;
        LinkedList<Race> races = null;
        Race race = null;
        double CFR;
        for (int i = 0; i < 6; i++) {
            state = states.get(i);
            races = state.getRace();
            races.insertionSort(new SortByAlpha());
            System.out.println(state.getName());
            for (int x = 0; x < 5; x++) {
                race = races.get(x);
                System.out.print(race.getRace() + ": ");
                System.out.print(race.getCases() + " cases, ");
                CFR = race.calculateCFR();
                if (CFR == -1.0 || CFR == 1.0) {
                    System.out.println(((int)CFR) + "% CFR");
                }
                else {
                    System.out.println(race.calculateCFR() + "% CFR");
                }               
            }
            System.out.println("=====");
            races.insertionSort(new SortByCFR());
            for (int x = 0; x < 5; x++) {
                race = races.get(x);
                System.out.print(race.getRace() + ": ");
                System.out.print(race.getCases() + " cases, ");
                CFR = race.calculateCFR();
                if (CFR == -1.0 || CFR == 1.0) {
                    System.out.println(((int)CFR) + "% CFR");
                }
                else {
                    System.out.println(race.calculateCFR() + "% CFR");
                }
            }
            System.out.println("=====");
        }
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
