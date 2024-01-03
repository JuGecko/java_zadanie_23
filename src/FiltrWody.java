public class FiltrWody extends Komponent {
    public static int zywotnosc;
    FiltrWody(int zywotnosc, int uzycie, boolean isWorking){
        super(uzycie, isWorking);
        FiltrWody.zywotnosc = zywotnosc;
    }

    public void sprawdzStanFiltra(){
        if(zywotnosc-this.wartosc<=0){
            System.out.println("UWAGA: WYMIEN FILTR! Aktualny stan: " + (zywotnosc-this.wartosc));
        }
        else {
            System.out.println("Pozostalo (filtr): " + (zywotnosc-this.wartosc) + " uzyc.");
        }
    }

    public void wymianaFiltra(){
        zywotnosc = 1000;
    }
}
