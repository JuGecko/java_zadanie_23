public class Komponent {
    public int wartosc;
    public boolean isWorking;

    Komponent(int wartosc, boolean isWorking){
        this.wartosc = wartosc;
        this.isWorking = isWorking;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
