public class GrzalkaWody extends Komponent {
    GrzalkaWody(int temp, boolean isWorking){
        super(temp, isWorking);
    }

    public void ustawTemp(int temp){
        this.wartosc = temp;
    };
}
