public class RegulatorPredkosci extends Komponent {
    RegulatorPredkosci(int predkosc, boolean isWorking){
        super(predkosc, isWorking);
    }

    public void ustawObroty(int predkosc){
        this.wartosc = predkosc;
    }
}
