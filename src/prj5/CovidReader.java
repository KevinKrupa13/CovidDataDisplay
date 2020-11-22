package prj5;

/**
 * CovidReader is the class we use
 * to read through our data
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CovidReader {

    private LinkedList<State> states;

    /**
     * Constructor for the covid reader class
     * 
     * Modifies the states linked list to hold all
     * the states with their respective
     * race linked lists after scanning through the data
     * 
     * @param fileName
     *            File you are scanning through
     * @throws FileNotFoundException
     *             Thrown if the file was not found
     * @throws CovidDataException
     *             Thrown if the file was missing information
     */
    public CovidReader(String fileName) throws FileNotFoundException {
        states = new LinkedList<State>();
        dataReader(fileName);
    }


    /**
     * Private dataReader method reads through the data
     * and modifies the states variable
     * 
     * @param filename
     *            File you are scanning
     * @throws FileNotFoundException
     *             Thrown if the file was not found
     */
    private void dataReader(String filename) throws FileNotFoundException {
        File input = new File(filename);
        Scanner scan = new Scanner(input);
        scan.nextLine();
        while (scan.hasNextLine()) {
            String a = scan.nextLine();
            String[] data = a.split(",", 11);
            String state = data[0];
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


    /**
     * Private parseInt method turns the passed
     * array of strings into an array of
     * ints to store their data
     * 
     * @param data
     *            Array you are turning to ints
     * 
     * @return The array of ints
     */
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


    /**
     * Getter method for the states variable
     * 
     * @return LinkedList of type state
     */
    public LinkedList<State> getStates() {
        return states;
    }


    /**
     * Private printer method prints out the information
     * as expected by the input test class
     */
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
                if (CFR % 1 == 0) {
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
                if (CFR % 1 == 0) {
                    System.out.println(((int)CFR) + "% CFR");
                }
                else {
                    System.out.println(race.calculateCFR() + "% CFR");
                }
            }
            System.out.println("=====");
        }
    }
}
