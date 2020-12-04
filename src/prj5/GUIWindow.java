package prj5;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

public class GUIWindow {

    private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 600;
    private static final int BARS = 5;
    private static final int BAR_WIDTH = 20;
    private static final int[] XBAR = { WINDOW_WIDTH / (BARS + 1), WINDOW_WIDTH
        / (BARS + 1) * 2, WINDOW_WIDTH / (BARS + 1) * 3, WINDOW_WIDTH / (BARS
            + 1) * 4, WINDOW_WIDTH / (BARS + 1) * 5 };
    private static final int YBAR = WINDOW_HEIGHT - 300;
    private static final int HEIGHT_FACTOR = 30;

    private Window window;
    private Button repDC;
    private Button repGA;
    private Button repMD;
    private Button repNC;
    private Button repTN;
    private Button repVA;
    private Button quit;
    private Button sortByAlpha;
    private Button sortByCFR;
    private CovidReader reader;
    private State stateGraph;
    LinkedList<State> state;
    LinkedList<Race> race;
    Iterator<State> stateIter;
    Iterator<Race> raceIter;
    DecimalFormat df;
    private int sort;

    /**
     * Constructor for the GUI window
     * 
     * @param args
     *            filename
     * @param reader
     *            covidreader
     * @throws FileNotFoundException
     */
    public GUIWindow(String args, CovidReader reader)
        throws FileNotFoundException {
        window = new Window("Covid data visualisation");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.reader = reader;
        sort = 0;
        state = reader.getStates();
        stateIter = state.iterator();
        stateIter.next();
        stateGraph = null;
        df = new DecimalFormat("###.#");

        sortByAlpha = new Button("Sort By Alpha");
        sortByAlpha.onClick(this, "sortByAlpha");
        window.addButton(sortByAlpha, WindowSide.NORTH);

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);

        sortByCFR = new Button("Sort By CFR");
        sortByCFR.onClick(this, "sortByCFR");
        window.addButton(sortByCFR, WindowSide.NORTH);

        repDC = new Button("Represent DC");
        repDC.onClick(this, "clickedRepDC");
        window.addButton(repDC, WindowSide.SOUTH);

        repGA = new Button("Represent GA");
        repGA.onClick(this, "clickedRepGA");
        window.addButton(repGA, WindowSide.SOUTH);

        repMD = new Button("Represent MD");
        repMD.onClick(this, "clickedRepMD");
        window.addButton(repMD, WindowSide.SOUTH);

        repNC = new Button("Represent NC");
        repNC.onClick(this, "clickedRepNC");
        window.addButton(repNC, WindowSide.SOUTH);

        repTN = new Button("Represent TN");
        repTN.onClick(this, "clickedRepTN");
        window.addButton(repTN, WindowSide.SOUTH);

        repVA = new Button("Represent VA");
        repVA.onClick(this, "clickedRepVA");
        window.addButton(repVA, WindowSide.SOUTH);
    }


    /**
     * method for the clickedRepDC button
     * 
     * @param button
     *            for clickedRepDC
     */
    public void clickedRepDC(Button button) {
        clickedRep(state.get(0));
    }


    /**
     * method for the clickedRepGA button
     * 
     * @param button
     *            for clickedRepGA
     */
    public void clickedRepGA(Button button) {
        clickedRep(state.get(1));
    }


    /**
     * method for the clickedRepMD button
     * 
     * @param button
     *            for clickedRepMD
     */
    public void clickedRepMD(Button button) {
        clickedRep(state.get(2));
    }


    /**
     * method for the clickedRepNC button
     * 
     * @param button
     *            for clickedRepNC
     */
    public void clickedRepNC(Button button) {
        clickedRep(state.get(3));
    }


    /**
     * method for the clickedRepTN button
     * 
     * @param button
     *            for clickedRepTN
     */
    public void clickedRepTN(Button button) {
        clickedRep(state.get(4));
    }


    /**
     * method for the clickedRepVA button
     * 
     * @param button
     *            for clickedRepVA
     */
    public void clickedRepVA(Button button) {
        clickedRep(state.get(5));
    }


    /**
     * helper method for the clickedRep buttons
     * 
     * @param button
     *            for clickedRep
     */
    private void clickedRep(State curr) {
        window.removeAllShapes();
        stateGraph = curr;
        changeGraphTitle(curr.getName());
        if (sort == 0) {
            race = curr.sortByCFR();
        }
        else {
            race = curr.sortByAlpha();
        }
        showRaces(race);
    }


    /**
     * clickedQuit method
     * 
     * @param button
     *            that quits window
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * helper method that changes the title of the graph
     * depending on the rep
     * 
     * @param name
     *            of rep state
     */
    private void changeGraphTitle(String name) {
        TextShape title = new TextShape(0, 30, name
            + " Case Fatality Ratios by Race");
        title.setX(WINDOW_WIDTH / 2 - title.getWidth() / 2);
        window.addShape(title);
    }


    /**
     * helper method that displays the races below the bars
     * 
     * @param race
     *            list of races
     */
    private void showRaces(LinkedList<Race> race) {
        raceIter = race.iterator();
        int i = 0;
        while (raceIter.hasNext()) {
            Race curr = raceIter.next();
            window.addShape(createShape(i, curr.calculateCFR()));
            window.addShape(new TextShape(XBAR[i] - BAR_WIDTH / 2, YBAR + 10,
                curr.getRace()));
            if (curr.calculateCFR() > -1) {
                window.addShape(new TextShape(XBAR[i] - BAR_WIDTH / 2, YBAR
                    + 40, String.valueOf(df.format(curr.calculateCFR())
                        + "%")));
            }
            i++;
        }
    }


    /**
     * helper method that creates the bars
     * 
     * @param index
     *            for x bar
     * @param CFR
     *            for height of bar
     * @return
     */
    private Shape createShape(int index, double CFR) {
        if (CFR > 0) {
            int height = (int)(HEIGHT_FACTOR * CFR);
            return new Shape(XBAR[index], YBAR - height, BAR_WIDTH, height,
                Color.BLUE);
        }
        else {
            return new TextShape(XBAR[index], YBAR - 10, "NA");
        }
    }


    /**
     * method for the sortByCFR button
     * 
     * @param button
     *            sortByCFR button
     */
    public void sortByCFR(Button button) {
        window.removeAllShapes();
        if (stateGraph == null) {
            sort = 0;
        }
        else {
            sort = 0;
            changeGraphTitle(stateGraph.getName());
            race = stateGraph.sortByCFR();
            showRaces(race);
        }
    }


    /**
     * method for the sortByAlpha button
     * 
     * @param button
     *            sortByAlpha button
     */
    public void sortByAlpha(Button button) {
        window.removeAllShapes();
        if (stateGraph == null) {
            sort = 1;
        }
        else {
            sort = 1;
            changeGraphTitle(stateGraph.getName());
            race = stateGraph.sortByAlpha();
            showRaces(race);
        }
    }

}
