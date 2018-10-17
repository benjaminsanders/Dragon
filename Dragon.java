/*
 * Dragons Lair Simulator
 * contact@benjaminsanders.net
 */
//package dragon;
import java.io.*;
import java.util.*;

public class Dragon {
    // Default speed in bits per second for serial line  simulation
    // Set 0 to disable
    static int SPEED = 10000;

    // ANSI Terminal codes
    static final String ESC = "\033";

    static String clearScreen() { return "\033[2J"; }
    static String cursorHome() { return "\033[H"; }
    static String cursorTo(int row, int column) {
    return String.format("\033[%d;%dH", row, column);
    }
    static String cursorSave() { return "\033[s"; }
    static String cursorRestore() { return "\033[u"; }

    static String scrollScreen() { return "\033[r"; }
    static String scrollSet(int top, int bottom) {
    return String.format("\033[%d;%dr", top, bottom);
    }
    static String scrollUp() { return "\033D"; }
    static String scrollDown() { return "\033D"; }

    static String setAt(int attr) {
    return String.format("\033[%dm", attr);
    }

    //Define special function characters
    static final int ATTR_RESET = 0;
    static final int ATTR_BRIGHT = 1;
    static final int ATTR_USCORE = 4;
    static final int ATTR_BLINK = 5;
    static final int ATTR_REVERSE = 7;

    //Define text colours
    static final int ATTR_FCOL_BLACK = 30;
    static final int ATTR_FCOL_RED = 31;
    static final int ATTR_FCOL_GREEN = 32;
    static final int ATTR_FCOL_YELLOW = 33;
    static final int ATTR_FCOL_BLUE = 34;
    static final int ATTR_FCOL_MAGENTA = 35;
    static final int ATTR_FCOL_CYAN = 36;
    static final int ATTR_FCOL_WHITE = 37;

    //Define alternate colours
    static final int ATTR__BCOL_BLACK = 40;
    static final int ATTR__BCOL_RED = 41;
    static final int ATTR__BCOL_GREEN = 42;
    
    
    //Multi-use Variables
    static int counterA = 0;
    static String msg = "";
    
    
    public static void main(String[] args) {
        
        

    
    
    
    //Show Intro Screen + Load Data Screen   
    screenIntro();
    
    //Show Intro Screen & Load Data 
    //String logData = loadDataScreen();
    //slowPrint(logData);
    
    //Print Background
    SPEED = 4096; 
    screenLayout();
    
    //Set Standard Speed
    SPEED = 1280;
    
    
    
    
    
    
    
    /*slowPrint("This "
              + setAt(ATTR_USCORE) + "should be undescored\n"
          + setAt(ATTR_RESET)
          + setAt(ATTR_FCOL_RED) + "and this red\n"
          + setAt(ATTR_RESET)
          + "some "
          + setAt(ATTR_BRIGHT)
          + setAt(ATTR_FCOL_YELLOW)
          + setAt(ATTR_BLINK) + "BRIGHT YELLOW BLINKIN\n"
          + setAt(ATTR_RESET)
          + "could be fun.\n\n"
          + "Please press ENTER");*/

    // Wait for ENTER
    try { System.in.read(); } catch(IOException e) {e.printStackTrace();}


    // reset text attributes, reset scroll area and set cursor
    // below scroll area
    //System.out.print(setAt(ATTR_RESET));
    //System.out.print(scrollScreen());
    //System.out.println(cursorTo(22,1));
        }

    
    
    private static void slowPrint(String s) {
    slowPrint(s, SPEED);
    }

    
    
    private static void slowPrint(String s, int bps) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));

            if(bps == 0) continue;

            try { Thread.sleep((int)(8000.0 / bps)); }
            catch(InterruptedException ex)
            { Thread.currentThread().interrupt(); }
        }
    }

    
    

    private static void screenIntro(){
    SPEED = 4096;    
    // example string showing some text attributes
    String s = setAt(ATTR_FCOL_RED) +
    "\n             d8b                                                        \n" +
    "             88P                                                        \n" +
    "            d88                                                         \n" +
    "        d888888    88bd88b d888b8b   d888b8b   d8888b   88bd88b  .d888b,\n" +
    "       d8P' ?88    88P'  `d8P' ?88  d8P' ?88  d8P' ?88  88P' ?8b ?8b,   \n" +
    "       88b  ,88b  d88     88b  ,88b 88b  ,88b 88b  d88 d88   88P   `?8b \n" +
    "       `?88P'`88bd88'     `?88P'`88b`?88P'`88b`?8888P'd88'   88b`?888P' \n" +
    "                                           )88                          \n" +
    "                                          ,88P                          \n" +
    "                                      `?8888P                           \n\n" +
    "              d8b             d8,                                       \n" +
    "              88P            `8P                                        \n" +
    "             d88                                                        \n" +
    "             888   d888b8b    88b  88bd88b                              \n" +
    "             ?88  d8P' ?88    88P  88P'  `                              \n" +
    "              88b 88b  ,88b  d88  d88                                   \n" +
    "               88b`?88P'`88bd88' d88'                                   \n\n\n";

    // Reset scrolling, clear screen and bring cursor home
    System.out.print(clearScreen());
    System.out.print(scrollScreen());

    // Print intro string & pause
    slowPrint(s); 
    loadDataScreen();
    }
    
    
    
    private static void loadDataScreen(){
    slowPrint(cursorTo(21,15) + "==================================================");
    slowPrint(cursorTo(23,15) + "==================================================");
    slowPrint(cursorTo(25,15) + "==================================================");
    slowPrint(cursorTo(22,15) + "X");

    String loadMsg[] = {
        "             Generating Imp Droppings             ",
        "            Formatting Treasure Chests            ",
        "                 Organizing Mugs                  ",
        "                 Cleaning The Bar                 ",
        "                  Torturing Orcs                  ",
        "                 Generating Grist                 ",
        "                 Fermenting......                 ",
        "                 Dispelling Magic                 ",
        "               Overcharging Patrons               ",
        "                 Swapping Barrels                 ",
        "                 Sweeping Up Trash                ",
        "          Repairing Water Wheel Bearings          ",
        "             Repairing Waterway Leaks             ",
        "              Disposing Of Orc Corpse             ",
        "   Performing 'Advanced Interrogation' On An Orc  ",
        "                 Breaking Up Fight                ",
        "               Poisoning Orcs Drink               ",
        "        Giving Inspirational Speech To Imp        ",
        "Someone left their horse. Just like, left it here.",
        "                 Watering Down Ale                "};

    //Print default message
    SPEED = 4096;
    slowPrint(cursorTo(24,15) + loadMsg[(int )(Math.random() * loadMsg.length - 1)]);

    counterA=0;
    while(counterA<50){
        SPEED = (int )(Math.random() * 1024 + 256);
        slowPrint(cursorTo(22,15+counterA) + setAt(ATTR_FCOL_RED) + "X");
        counterA++;

        
        //Select only ONE! Comment out other if statement.
        /* Static Variable */   if(counterA==8|counterA==16|counterA==24|counterA==32|counterA==40){
        /* Random Variable */// if(((int )(Math.random() * 20 + 1)) < 3){
            SPEED = 4096;
            slowPrint(cursorTo(24,15) + loadMsg[(int )(Math.random() * loadMsg.length - 1)]);
        }
        
        if(counterA==8){
            
            File f = new File("log.txt");
            if(f.exists() && !f.isDirectory()) { 
            msg= loadData("log.txt");
            slowPrint(cursorTo(26,15) + setAt(ATTR_FCOL_GREEN) + "          Loading from " + System.getProperty("user.dir") + "/log.txt");
            }else{
                System.out.print(setAt(ATTR_RESET));
                System.out.print(scrollScreen());
                screenLog(); 
            }
            
    
        }

    }

    // Reset scrolling, clear screen and bring cursor home
        System.out.print(clearScreen());
        System.out.print(scrollScreen());
     
    //Return file data string    
    //return loadMessage;
    }
    
    
    
    static void screenLog(){
        System.out.print(setAt(ATTR_RESET));
        System.out.print(scrollScreen());
        SPEED = 25000;   
        slowPrint("\n"+setAt(ATTR__BCOL_RED)+setAt(ATTR_FCOL_BLACK));	//Set Text & Background Color
        slowPrint("┌──────────────────────────────────────────────────────────────────────────────┐\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│               "+setAt(ATTR__BCOL_GREEN)+"┌─────────────── DRAGONS LAIR ─────────────────┐"+setAt(ATTR__BCOL_RED)+"               │\n");
        slowPrint("│               "+setAt(ATTR__BCOL_GREEN)+"│                                              │"+setAt(ATTR__BCOL_RED)+"               │\n");
        slowPrint("│               "+setAt(ATTR__BCOL_GREEN)+"│  The Dragons Lair requires a log file that   │"+setAt(ATTR__BCOL_RED)+"               │\n");
        slowPrint("│               "+setAt(ATTR__BCOL_GREEN)+"│  seems to be missing or invalid. Would you   │"+setAt(ATTR__BCOL_RED)+"               │\n");
        slowPrint("│               "+setAt(ATTR__BCOL_GREEN)+"│  like to create the file '../log.txt'?       │"+setAt(ATTR__BCOL_RED)+"               │\n");
        slowPrint("│               "+setAt(ATTR__BCOL_GREEN)+"│                                              │"+setAt(ATTR__BCOL_RED)+"               │\n");
        slowPrint("│               "+setAt(ATTR__BCOL_GREEN)+"│       [ ] YES                   [ ]NO        │"+setAt(ATTR__BCOL_RED)+"               │\n");
        slowPrint("│               "+setAt(ATTR__BCOL_GREEN)+"└──────────────────────────────────────────────┘"+setAt(ATTR__BCOL_RED)+"               │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│-                                                                             │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("│                                                                              │\n");
        slowPrint("└──────────────────────────────────────────────────────────────────────────────┘");
        
        // Wait for ENTER
        try { System.in.read(); } catch(IOException e) {e.printStackTrace();}
        System.out.print(setAt(ATTR_RESET));
        System.out.print(scrollScreen());
        screenIntro();
    }
    
    
    
    static void screenLayout(){
        slowPrint(setAt(ATTR_FCOL_WHITE));
        slowPrint("┌──────────────┬───────────────────┬────────────────────────────────┬──────────┐\n");
        slowPrint("│              │ "+setAt(ATTR_FCOL_BLACK)+setAt(ATTR__BCOL_RED)+"THE DRAGON'S LAIR"+setAt(ATTR__BCOL_BLACK)+setAt(ATTR_FCOL_WHITE)+" │                                │   BANK   │\n");
        slowPrint("├──┬─────────┬─┴────┬────────┬─────┴───┬─┬───┬───┬───┬──────────────┤          │\n");
        slowPrint("│"+setAt(ATTR_FCOL_GREEN)+"ID"+setAt(ATTR_FCOL_WHITE)+"│  "+setAt(ATTR_FCOL_GREEN)+"NAME"+setAt(ATTR_FCOL_WHITE)+"   │ "+setAt(ATTR_FCOL_GREEN)+"RACE"+setAt(ATTR_FCOL_WHITE)+" │ "+setAt(ATTR_FCOL_GREEN)+"CLASS"+setAt(ATTR_FCOL_WHITE)+"  │ "+setAt(ATTR_FCOL_GREEN)+"HISTORY"+setAt(ATTR_FCOL_WHITE)+" │"+setAt(ATTR_FCOL_GREEN)+"♂"+setAt(ATTR_FCOL_WHITE)+"│"+setAt(ATTR_FCOL_GREEN)+"GLD"+setAt(ATTR_FCOL_WHITE)+"│"+setAt(ATTR_FCOL_GREEN)+"SLV"+setAt(ATTR_FCOL_WHITE)+"│"+setAt(ATTR_FCOL_GREEN)+"CPR"+setAt(ATTR_FCOL_WHITE)+"│"+setAt(ATTR_FCOL_GREEN)+"CURRENT ACTION"+setAt(ATTR_FCOL_WHITE)+"│"+setAt(ATTR_FCOL_YELLOW)+"GOLD"+setAt(ATTR_FCOL_WHITE)+"      │\n");
        slowPrint("├──┼─────────┴──────┴────────┴─────────┴─┴───┴───┴───┴──────────────┤SILVER    │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 1"+setAt(ATTR_FCOL_WHITE)+"│                                                                │"+setAt(ATTR_FCOL_RED)+"COPPER"+setAt(ATTR_FCOL_WHITE)+"    │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 2"+setAt(ATTR_FCOL_WHITE)+"│                                                                │          │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 3"+setAt(ATTR_FCOL_WHITE)+"│                                                                ├──────────┤\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 4"+setAt(ATTR_FCOL_WHITE)+"│                                                                ├──────────┤\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 5"+setAt(ATTR_FCOL_WHITE)+"│                                                                │  DRINKS  │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 6"+setAt(ATTR_FCOL_WHITE)+"│                                                                │          │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 7"+setAt(ATTR_FCOL_WHITE)+"│                                                                │ALE       │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 8"+setAt(ATTR_FCOL_WHITE)+"│                                                                │WINE      │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+" 9"+setAt(ATTR_FCOL_WHITE)+"│                                                                │          │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"10"+setAt(ATTR_FCOL_WHITE)+"│                                                                ├──────────┤\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"11"+setAt(ATTR_FCOL_WHITE)+"│                                                                ├──────────┤\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"12"+setAt(ATTR_FCOL_WHITE)+"│                                                                │   INFO   │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"13"+setAt(ATTR_FCOL_WHITE)+"│                                                                │          │\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"14"+setAt(ATTR_FCOL_WHITE)+"│                                                                │WATER   "+setAt(ATTR_FCOL_GREEN)+"OK"+setAt(ATTR_FCOL_WHITE)+"│\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"15"+setAt(ATTR_FCOL_WHITE)+"│                                                                │WHEEL   "+setAt(ATTR_FCOL_GREEN)+"OK"+setAt(ATTR_FCOL_WHITE)+"│\n"); 
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"16"+setAt(ATTR_FCOL_WHITE)+"│                                                                │CRUSHER "+setAt(ATTR_FCOL_GREEN)+"OK"+setAt(ATTR_FCOL_WHITE)+"│\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"17"+setAt(ATTR_FCOL_WHITE)+"│                                                                │MASHTUN "+setAt(ATTR_FCOL_GREEN)+"OK"+setAt(ATTR_FCOL_WHITE)+"│\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"18"+setAt(ATTR_FCOL_WHITE)+"│                                                                │BOILER  "+setAt(ATTR_FCOL_GREEN)+"OK"+setAt(ATTR_FCOL_WHITE)+"│\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"19"+setAt(ATTR_FCOL_WHITE)+"│                                                                │FERMENT "+setAt(ATTR_FCOL_GREEN)+"OK"+setAt(ATTR_FCOL_WHITE)+"│\n");
        slowPrint("│"+setAt(ATTR_FCOL_CYAN)+"20"+setAt(ATTR_FCOL_WHITE)+"│                                                                │LIFTS   "+setAt(ATTR_FCOL_GREEN)+"OK"+setAt(ATTR_FCOL_WHITE)+"│\n");
        slowPrint("└──┴────────────────────────────────────────────────────────────────┴──────────┘");
    }
    
    
    static String loadData(String filename){
        String dataFeed = "";
        try {
            FileReader reader = new FileReader(filename);
            int character;
            while ((character = reader.read()) != -1) {
                dataFeed = dataFeed + ((char) character);
            }
            reader.close();
            
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFeed;
    }
    
}
