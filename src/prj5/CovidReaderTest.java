package prj5;

import java.io.FileNotFoundException;

public class CovidReaderTest extends student.TestCase {

    @SuppressWarnings("unused")
    private CovidReader reader;
    
    public void testReader() throws CovidDataException, FileNotFoundException {
        
        reader = new CovidReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        
        
    }

}
