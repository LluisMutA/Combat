import java.util.Scanner;

enum Estrategia {
    ATAC, DEFENSA, MANIOBRA, ENGANY
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quin nom vols emprar? ");
        String nom = scanner.nextLine().trim();
        System.out.println("Quin tipus de personatge vols ser? (M, C, O, E, D)");
        String tipus = scanner.nextLine().toUpperCase();
        Lluitador jugadorHuma = creaLluitador(nom, tornaTipusSegonsString(tipus));
        if (jugadorHuma == null){
            System.out.println("No pots crear un jugador amb aquests parametres");
            return;
        }

        Lluitador bot = creaLluitador("skynet", Lluitador.tipusAleatori());

        for (int i = 0; i  < 999; i++) {
            dibuixaPantalla(jugadorHuma, bot, true);
            Screen.printScreen();
            Estrategia estratHuma = triaEstrategiaHuma();
            Estrategia estratBot = triaEstrategiaBot();
            dibuixaPantalla(jugadorHuma, bot, false);
            dibuixaEstrategies(estratHuma, estratBot, 1, 1);
            lluita(jugadorHuma, bot, estratHuma, estratBot);
            Screen.printScreen();
            esperaXSegons(2);

            if (jugadorHuma.puntsVida <= 0) {
                Screen.fillScreen(' ');
                Screen.drawGraphics(2,10,Screen.gameover);
                Screen.printScreen();
                break;
            }
            if (bot.puntsVida <= 0) {
                jugadorHuma.nivell++;
                bot.nivell++;
                bot.puntsVida = bot.puntsVidaMaxim + 10;
                bot.puntsVidaMaxim = bot.puntsVidaMaxim + 10;
                jugadorHuma.puntsVida = jugadorHuma.puntsVidaMaxim + 10;
                jugadorHuma.puntsVidaMaxim = jugadorHuma.puntsVidaMaxim + 10;
                jugadorHuma.ATK = jugadorHuma.ATK + 3;
                jugadorHuma.DEF = jugadorHuma.DEF + 3;
                bot.ATK = bot.ATK +3;
                bot.DEF = bot.DEF + 3;
            }
            if (jugadorHuma.nivell == 5) {
                Screen.fillScreen(' ');
                Screen.drawGraphics(2, 10, Screen.victoria);
                Screen.printScreen();
                break;
            }
        }
    }

    static void dibuixaEstrategies(Estrategia e1, Estrategia e2, int p1, int p2) {
        Screen.drawText(12, 6, String.format("%s [%d]",e1.toString(), p1));
        Screen.drawText(55, 6, String.format("%s [%d]",e2.toString(), p2));
    }

    static void esperaXSegons(int s) {
        try {
            Thread.sleep(s);
          } catch (Exception e){
        }
    }

    static void dibuixaPantalla(Lluitador l1, Lluitador l2, boolean mostraPersonatges) {
        // Esborra la pantalla
        Screen.fillScreen(' ');
        if (mostraPersonatges) {
            // Dibuixa les capses
            Screen.drawBox(0, 0, 42, 7);
            Screen.drawBox(43, 0, 42, 7);
            // Dibuixa la info del jugador
            dibuixaInfoJugador(l1, 2, 1, mostraPersonatges);
            dibuixaInfoJugador(l2, 45, 1, mostraPersonatges);

        }else if (!mostraPersonatges) {
            Screen.drawGraphics(15, 7, Screen.fight);
        }
    }

    static void dibuixaInfoJugador(Lluitador lluitador, int x, int y, boolean mostraGrafic) {
        Screen.drawText(x,y,String.format("%s [%s]", lluitador.getNom(), lluitador.getTipus()));
        Screen.drawText(x,y+1, String.format("Vida: %d/ %d", lluitador.getPuntsVida(), lluitador.puntsVidaMaxim));
        Screen.drawText(x,y+2, String.format("Atac: %d", lluitador.ATK));
        Screen.drawText(x,y+3, String.format("Defensa: %d", lluitador.DEF));
        Screen.drawText(x,y+4, String.format("Nivell: %s", lluitador.nivell));
        String graphic = "";
        if (lluitador.getTipus() == Lluitador.tipusJugador.Mag) graphic = Screen.mag;
        if (lluitador.getTipus() == Lluitador.tipusJugador.Ogre) graphic = Screen.ogre;
        if (lluitador.getTipus() == Lluitador.tipusJugador.Cavaller) graphic = Screen.cavaller;
        if (lluitador.getTipus() == Lluitador.tipusJugador.Elf) graphic = Screen.elf;
        if (lluitador.getTipus() == Lluitador.tipusJugador.Dracònid) graphic = Screen.dracònid;
        if (mostraGrafic) {
            Screen.drawGraphics(x, 10, graphic);
        }
    }


    static Estrategia triaEstrategiaHuma(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Quina estrategia vols utilitzar? (A, D, M, E)");
            String resposta = scanner.nextLine().toUpperCase();
            if (resposta.equals("A")) return Estrategia.ATAC;
            if (resposta.equals("D")) return Estrategia.DEFENSA;
            if (resposta.equals("M")) return Estrategia.MANIOBRA;
            if (resposta.equals("E")) return Estrategia.ENGANY;
        }
    }
    static void lluita(Lluitador l1, Lluitador l2, Estrategia e1, Estrategia e2){
        int power1 = calculaPower(l1, e1);
        int power2 = calculaPower(l2, e2);

        dibuixaEstrategies(e1, e2, power1, power2);

        if (!resultatCombat(l1, l2, e1, e2, power1, power2))
        resultatCombat(l2, l1, e2, e1, power2, power1);
    }

    static boolean resultatCombat(Lluitador jugador, Lluitador adversari,
                                       Estrategia ejugador, Estrategia eadversari, int powerJugador, int powerAdversari) {
        if (ejugador == Estrategia.ATAC && eadversari == Estrategia.ATAC) {
            // Dany a tots 2
            jugador.dany(powerAdversari);
            adversari.dany(powerJugador);
            return true;
        }
        if (ejugador == Estrategia.ATAC && eadversari == Estrategia.DEFENSA) {
            // Adversari guarit
            adversari.guarit(powerAdversari);
            return true;
        }
        if (ejugador == Estrategia.ATAC && (eadversari == Estrategia.ENGANY || eadversari == Estrategia.MANIOBRA)) {
            // Adversari dany
            adversari.dany(powerJugador);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////
        if (ejugador == Estrategia.DEFENSA && eadversari == Estrategia.DEFENSA) {
            // Jugador i Adversari guarit
            adversari.guarit(powerAdversari);
            jugador.guarit(powerJugador);
            return true;
        }
        if (ejugador == Estrategia.DEFENSA && eadversari == Estrategia.ENGANY) {
            // Jugador Dany x2
            jugador.dany(powerAdversari*2);
            return true;
        }
        if (ejugador == Estrategia.DEFENSA && eadversari == Estrategia.MANIOBRA) {
            // Jugador penalitzat
            jugador.penalitzat(powerAdversari);
            return true;
        }
        //////////////////////////////////////////////////////////////////////////////
        if (ejugador == Estrategia.ENGANY && eadversari == Estrategia.ENGANY) {
            // Dany a tots 2
            jugador.dany(powerAdversari);
            adversari.dany(powerJugador);
            return true;
        }
        if (ejugador == Estrategia.ENGANY && eadversari == Estrategia.MANIOBRA) {
            // Jugagor penalitzat
            jugador.penalitzat(powerAdversari);
            return true;
        }
        /////////////////////////////////////////////////////////////////////////////
        if (ejugador == Estrategia.MANIOBRA && eadversari == Estrategia.MANIOBRA) {
            // Jugagot i Adversari penalitzat
            jugador.penalitzat(powerAdversari);
            adversari.penalitzat(powerJugador);
            return true;
        }            return false;
    }
            static int calculaPower(Lluitador l, Estrategia e){
        if (e == Estrategia.ATAC || e == Estrategia.ENGANY){
            // Tiram tantes monedes com capacitat d'atac
            return (int) (Math.random()*l.getATK()+1);
        }
        // Tiram tantes monedes com capacitat de defensa
        return (int) (Math.random()*l.getDEF()+1);
    }
    static Estrategia triaEstrategiaBot(){
        Estrategia [] ar = Estrategia.values();
        int index = (int) (Math.random()*ar.length);
        return ar[index];
    }


    static Lluitador.tipusJugador tornaTipusSegonsString(String tipus){
        if (tipus.equals("M")){
            return Lluitador.tipusJugador.Mag;
        } else if (tipus.equals("C")){
            return Lluitador.tipusJugador.Cavaller;
        } else if (tipus.equals("O")){
            return Lluitador.tipusJugador.Ogre;
        } else if (tipus.equals("E")) {
            return Lluitador.tipusJugador.Elf;
        } else if (tipus.equals("D")){
            return Lluitador.tipusJugador.Dracònid;
        }
        return null;
    }

    private static Lluitador creaLluitador(String nom, Lluitador.tipusJugador tipus) {
        Lluitador lluitador = new Lluitador();
        lluitador.setNom(nom);
       if(nom.length() == 0 || tipus == null) {
           return null;
       }
       lluitador.setTipus(tipus);

        if (lluitador.getTipus() == Lluitador.tipusJugador.Mag){
            lluitador.setPuntsVidaMaxim(20);
            lluitador.setATK(25);
            lluitador.setDEF(15);
        } else if (lluitador.getTipus() == Lluitador.tipusJugador.Cavaller) {
            lluitador.setPuntsVidaMaxim(3);
            lluitador.setATK(10);
            lluitador.setDEF(20);
        }else if (lluitador.getTipus() == Lluitador.tipusJugador.Ogre) {
            lluitador.setPuntsVidaMaxim(25);
            lluitador.setATK(15);
            lluitador.setDEF(20);
        }else if (lluitador.getTipus() == Lluitador.tipusJugador.Elf) {
            lluitador.setPuntsVidaMaxim(20);
            lluitador.setATK(27);
            lluitador.setDEF(13);
        }else if (lluitador.getTipus() == Lluitador.tipusJugador.Dracònid) {
            lluitador.setPuntsVidaMaxim(25);
            lluitador.setATK(30);
            lluitador.setDEF(5);
        }
        lluitador.setArma(Lluitador.tipusArma.Desarmat);
        lluitador.setPuntsVida(lluitador.getPuntsVidaMaxim());
        lluitador.setNivell(1);
        lluitador.setPuntsDoblers(0);
        return lluitador;
    }
}
