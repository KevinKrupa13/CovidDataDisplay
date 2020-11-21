package prj5;

import java.io.FileNotFoundException;

public class Input {
    
    public static void main(String[] args) throws FileNotFoundException, CovidDataException {
        CovidReader covidReader;
        if (args.length >= 2) {
            covidReader = new CovidReader(args[0]);
        }
        covidReader = new CovidReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        
    }

}
