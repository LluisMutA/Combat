public class Lluitador {



    public static tipusJugador tipusAleatori() {
        tipusJugador[] ar = tipusJugador.values();
        int index = (int) (Math.random()*ar.length);
        return ar[index];
    }
    enum tipusArma{
        Espasa, Arc, Bastó, Llança, Daga
    }

    enum tipusJugador {
        Ogre, Cavaller, Mag, Elf, Dracònid
    }
    String nom;
    tipusJugador tipus;
    tipusArma arma;
    int nivell;
    int puntsDoblers;
    int puntsVida;
    int puntsVidaMaxim;
    int ATK;
    int DEF;

    public String getNom() {
        return nom;
    }
    public void dany (int punts){
        this.puntsVida -= punts;
        if (this.puntsVida < 0) this.puntsVida = 0;
    }

    public void imprimeix(){
        System.out.printf("Jugador: %s. Vida: %d, Atac: %d, Defensa: %d\n",
        this.nom, this.puntsVida, this.ATK, this.DEF);
    }
    public void guarit (int punts){
        this.puntsVida += punts;
        if (this.puntsVida > this.puntsVidaMaxim) this.puntsVida = this.puntsVidaMaxim;
    }

    public void penalitzat (int punts) {
        // TODO: Eliminar cada X torns les penalitzacions
        if (Math.random() > 0.5){
            this.ATK -= punts;
        }else{
            this.DEF -= punts;
        }
        if (this.DEF < 0) this.DEF = 0;
        if (this.ATK < 0) this.ATK = 0;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public tipusJugador getTipus() {
        return tipus;
    }

    public void setTipus(tipusJugador tipus) {
        this.tipus = tipus;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public int getPuntsDoblers() {
        return puntsDoblers;
    }

    public void setPuntsDoblers(int puntsDoblers) {
        this.puntsDoblers = puntsDoblers;
    }

    public int getPuntsVida() {
        return puntsVida;
    }

    public void setPuntsVida(int puntsVida) {
        this.puntsVida = puntsVida;
    }

    public int getPuntsVidaMaxim() {
        return puntsVidaMaxim;
    }

    public void setPuntsVidaMaxim(int puntsVidaMaxim) {
        this.puntsVidaMaxim = puntsVidaMaxim;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }



}