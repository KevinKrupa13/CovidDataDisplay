package prj5;

import java.io.FileNotFoundException;

public class Input {

    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws FileNotFoundException,
        CovidDataException {
        CovidReader covidReader;
        if (args[0] != null) {
            covidReader = new CovidReader(args[0]);
        }
        else {
            covidReader = new CovidReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }

    }

}
