import static java.awt.Color.RED;

public class Screen {
    final static int SCREEN_WIDTH = 87;
    final static int SCREEN_HEIGHT = 30;
    final static String fight =
            "         @@@@@+       :*                         \n" +
            "        *@@@@@@        .==     @:    @@@@-       \n" +
            "        *@@@@@@          %* @+-     @@@@@=       \n" +
            "       ++:=@@@.          #@@        =@@@@=       \n" +
            "     .@*   @@@         @+. :@      %+#@#-@=@     \n" +
            "     @+* -@  @:    @@-       +=%  #      @  #    \n" +
            "     #-* .@  %+::@@@+         @@@# - @@@@@@@@@   \n" +
            "      %   #:   ==%:           -%%@@  @@= =   #   \n" +
            "      @ +=@# @#                   %    =.@       \n" +
            "     :@%    :=                     %==* .@.      \n" +
            "     :=@-#   .=                   .-@+-          \n" +
            "     ::  +@*   %.           .    %=    =:   .#   \n" +
            "     -: *.  -@  *         .@=@#           #      \n" +
            "    @@@+      .- @=      #  @               @@   \n" +
            "  -@*:-        @  =     @.@.                @@@@-\n" +
            "  @-@           @ %  @-@@@                  .....\n" +
            " -#=             :-+-::::                        \n";



    final static String mag = "" +
            "\033[36m           /^\\     .\n" +
            "\033[36m     /\\   \"V\"\n" +
            "\033[36m    /__\\   I      O  o\n" +
            "\033[36m   //..\\\\  I     .\n" +
            "\033[36m   \\].`[/  I\n" +
            "\033[36m   /l\\/j\\  (]    .  O\n" +
            "\033[36m  /. ~~ ,\\/I          .\n" +
            "\033[36m  \\\\L__j^\\/I       o\n" +
            "\033[36m   \\/--v}  I     o   .\n" +
            "\033[36m   |    |  I   _________\n" +
            "\033[36m   |    |  I c(`       ')o\n" +
            "\033[36m   |    l  I   \\.     ,/\n" +
            "\033[36m _/j  L l\\_!  _//^---^\\\\_    ";
    final static String cavaller = "      __      _\n" +
            "     /__\\__  //\n" +
            "    //_____\\///\n" +
            "   _| /-_-\\)|/_\n" +
            "  (___\\ _ //___\\\n" +
            "  (  |\\\\_/// * \\\\\n" +
            "   \\_| \\_((*   *))\n" +
            "   ( |__|_\\\\  *//\n" +
            "   (o/  _  \\_*_/\n" +
            "   //\\__|__/\\\n" +
            "  // |  | |  |\n" +
            " //  _\\ | |___)\n" +
            "//  (___|";
    final static String ogre = "\\033[32m   _____\n" +
            "\033[32m  _/ _ _ \\_  \n" +
            "\033[32m (o / | \\ o)\n" +
            "\033[32m  || o|o ||\n" +
            "\033[32m  | \\_|_/ |\n" +
            "\033[32m  |  ___  |\n" +
            "\033[32m  | (___) |\n" +
            "\033[32m  |\\_____/|\n" +
            "\033[32m  | \\___/ |\n" +
            "\033[32m  \\       /\n" +
            "\033[32m   \\__ __/\n" +
            "\033[32m      U";
    final static  String elf = " " +
            "\033[36m            ..-.--..\n" +
            "\033[36m          ,','.-`.-.`.\n" +
            "\033[36m         :.',;'     `.\\.\n" +
            "\033[36m         ||//----,-.--\\|\n" +
            "\033[36m       \\`:|/-----`-'--||'/\n" +
            "\033[36m        \\\\|:    |:'\n" +
            "\033[36m         `||      \\   |!\n" +
            "\033[36m         |!|          ;|\n" +
            "\033[36m         !||:.   --  /|!\n" +
            "\033[36m        /||!||:.___.|!||\\\n" +
            "\033[36m       /|!|||!|    |!||!\\\\:.\n" +
            "\033[36m    ,'//!||!||!`._.||!||,:\\\\\\\n" +
            "\033[36m   : :: |!|||!| SSt|!||! |!::\n" +
            "\033[36m   | |! !||!|||`---!|!|| ||!|\n";
    final static  String dracònid = "" +
            "\033[31m      /     \\\n" +
            "\033[31m     ((     ))\n" +
            "\033[31m ===  \\_v_//  ===\n" +
            "\033[31m   ====)_^_(====\n" +
            "\033[31m   ===/ O O \\===\n" +
            "\033[31m   = | /_ _\\ | =\n" +
            "\033[31m  =   \\/_ _\\/   =\n" +
            "\033[31m       \\_ _/\n" +
            "\033[31m       (o_o)\n" +
            "\033[31m        VwV";

    final static String gameover = "" +
            "\033[31m   _____                         ____                 \n" +
            "\033[31m  / ____|                       / __ \\                \n" +
            "\033[31m | |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ \n" +
            "\033[31m | | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__|\n" +
            "\033[31m | |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |   \n" +
            "\033[31m  \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   \n" +
            "\033[31m                                                      \n" +
            "                                                      ";
    final static String victoria = "" +
            "\033[34m __      ___      _   __        _       _ \n" +
            "\033[34m \\ \\    / (_)    | |  \\_\\      (_)     | |\n" +
            "\033[34m  \\ \\  / / _  ___| |_ ___  _ __ _  __ _| |\n" +
            "\033[34m   \\ \\/ / | |/ __| __/ _ \\| '__| |/ _` | |\n" +
            "\033[34m    \\  /  | | (__| || (_) | |  | | (_| |_|\n" +
            "\033[34m     \\/   |_|\\___|\\__\\___/|_|  |_|\\__,_(_)\n" +
            "\033[34m                                          \n" +
            "\033[34m                                          ";
    final static String espasa = "      /| ________________\n" +
            "O|===|* >________________>\n" +
            "      \\|";
    final static String arc = "   (\n" +
            "    \\\n" +
            "     )\n" +
            "##--------> \n" +
            "     )\n" +
            "    /\n" +
            "   (";
    final static String daga = "\n" +
            "[]++++||=======>";
    final static String llança = "                       ____" +
            "[=====================|____>>>";
    final static String basto = "             +-+\n" +
            "=============|@|\n" +
            "            `:@;'";
    static char[][] pixels = new char[SCREEN_HEIGHT][SCREEN_WIDTH];

    public static void main(String[] args) {
        fillScreen(' ');
        drawBox(0,0,42,4);
        drawBox(43, 0, 42, 4);
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
