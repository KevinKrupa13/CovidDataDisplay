package prj5;

import java.io.FileNotFoundException;

/**
 * Input is the runner class
 * which contains the main method
 * 
 * @author Kevin Krupa (kevinkrupa13)
 * @author Suha Dewan (suhad)
 * 
 * @version 2020.21.11
 */
public class Input {

    /**
     * Main method instantiates a new covidReader object
     * to start the backend
     * 
     * @param args
     *            Arguments used for covid reader
     * @throws FileNotFoundException
     *             Thrown if file is not found
     * @throws CovidDataException
     *             Thrown if file was missing information
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws FileNotFoundException {
        CovidReader covidReader;
        if (args[0] != null) {
            covidReader = new CovidReader(args[0]);
        }
        else {
            covidReader = new CovidReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }

    }

}
