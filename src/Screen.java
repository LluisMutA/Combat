public class Screen {
    final static int SCREEN_WIDTH = 87;
    final static int SCREEN_HEIGHT = 40;
    final static String fight = "";

    final static String mag = "";
    final static String cavaller = "";
    final static String ogre = "   _____\n" +
            " _/ _ _ \\_  \n" +
            "(o / | \\ o)\n" +
            " || o|o ||\n" +
            " | \\_|_/ |\n" +
            " |  ___  |\n" +
            " | (___) |\n" +
            " |\\_____/|\n" +
            " | \\___/ |\n" +
            " \\       /\n" +
            "  \\__ __/\n" +
            "     U";

    static char[][] pixels = new char[SCREEN_HEIGHT][SCREEN_WIDTH];

    public static void main(String[] args) {
        fillScreen(' ');
        drawBox(0,0,42,5);
        drawBox(43, 0, 42, 5);
        drawText(2,2,"Jugador 1:");
        drawText(45,2,"Jugador 2:");

        printScreen();
    }
    static void drawGraphics(int x, int y, String s){
        String[] ar = s.split("\n");
        for (int i = 0; i < ar.length; i++) {
            drawText(x,y,ar[i]);
            y++;
        }
    }

    static void drawText(int x, int y, String s) {
        for (int i = 0; i < s.length(); i++) {
            pixels[y][x+i] = s.charAt(i);
        }
    }

    static void drawBox(int x, int y, int width, int height) {
        if(x+width >= SCREEN_WIDTH){
            width = SCREEN_WIDTH - x;
        }
        if(y+height >= SCREEN_WIDTH){
            height = SCREEN_HEIGHT - y;
        }
        horizLine(x,y,width);
        horizLine(x,y+height-1, width);
        vertLine(x,y, height);
        vertLine(x+width-1,y, height);
        setPixel(x,y, '╔');
        setPixel(x+width-1,y,'╗');
        setPixel(x, y+height-1, '╚');
        setPixel(x+width-1, y+height-1, '╝');
    }

    static void vertLine(int x, int y, int len) {
        for (int i = 0; i < len; i++) {
            setPixel(x,y,'║');
            y++;
        }
    }

    static void horizLine(int x, int y, int len) {
        for (int i = 0; i < len; i++) {
            setPixel(x,y,'═');
            x++;
        }
    }

    static void setPixel (int x, int y, char c){
        pixels[y][x] = c;

    }

    static void printScreen() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                System.out.print(pixels[i][j]);
            }
            System.out.println();
        }
    }

    static void fillScreen (char c){
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                pixels[i][j] = c;
            }
        }
    }
}
