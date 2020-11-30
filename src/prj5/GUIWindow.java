package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.Window;

public class GUIWindow {

    private Window window;
    private Button repDC;
    private Button repGA;
    private Button repMD;
    private Button repNC;
    private Button repTN;
    private Button repVA;
    private Button quit;
    private Button SortByAlpha;
    private Button SortByCFR;
    private CovidReader reader;
    private Shape bar1Shape;
    private Shape bar2Shape;
    private Shape bar3Shape;
    private Shape bar4Shape;
    private Shape bar5Shape;
    
    private static final int BAR_HEIGHT = 10;

    public GUIWindow(Input filereader) {
        window = new Window("Covid data visualisation");
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        SortByAlpha = new Button("Sort By Alpha");
        SortByCFR = new Button("Sort By CFR");
        repDC = new Button("Represent DC");
        repGA = new Button("Represent GA");
        repMD = new Button("Represent MD");
        repNC = new Button("Represent NC");
        repTN = new Button("Represent TN");
        repVA = new Button("Represent VA");
    }


    /**
     * clickedQuit method
     * 
     * @param button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    public void sortByCFR(Button button) {
        window.removeAllShapes();
        
    }

}
