package Game;

public class Config {
    public static int  CELL_SIZE = 50;
    public static int FIELD_SIZE = 8;
    public static int SLEEP_MS = 500;
    public static boolean whiteColorStatus;
    public static void setSize(boolean colorStatus){
        whiteColorStatus = colorStatus;
    }
}
