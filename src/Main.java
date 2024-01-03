import java.util.Scanner;

public class Main {
    static class Pralka {
        public ElektrozaworyWodne elektrozawor;
        public FiltrWody filtr;
        public GrzalkaWody grzalka;
        public PojemnikUbran pojemnikUbrania;
        public PojemnikDetergenty pojemnikDetergenty;
        public PompaWody pompa;
        public RegulatorPredkosci regulatorPredkosci;
        public SilnikInwerterowy silnikInwerterowy;
        Pralka(ElektrozaworyWodne elektrozawor, FiltrWody filtr, GrzalkaWody grzalka, PojemnikUbran pojemnikUbrania,
               PojemnikDetergenty pojemnikDetergenty, PompaWody pompa, RegulatorPredkosci regulatorPredkosci,
               SilnikInwerterowy silnikInwerterowy){
            this.elektrozawor = elektrozawor;
            this.filtr = filtr;
            this.grzalka = grzalka;
            this.pojemnikUbrania = pojemnikUbrania;
            this.pojemnikDetergenty = pojemnikDetergenty;
            this.pompa = pompa;
            this.regulatorPredkosci = regulatorPredkosci;
            this.silnikInwerterowy = silnikInwerterowy;
        }

        public void POST(){
            Sensory sensory = new Sensory(elektrozawor.isWorking, grzalka.isWorking, pojemnikDetergenty.isWorking,
                    filtr.isWorking, pompa.isWorking, regulatorPredkosci.isWorking, silnikInwerterowy.isWorking);
            if(!sensory.SprawdzSensory()) {
                System.out.println("Pralka nie moze kontynuowac pracy.");
            } else {
                filtr.sprawdzStanFiltra();
            }
        }

        public void Menu(){
            System.out.println("---------------------------");
            System.out.println("     1. Pranie szybkie     ");
            System.out.println(" 2. Pranie w zimnej wodzie ");
            System.out.println(" 3. Odiez lekko zabrudzona ");
            System.out.println(" 4. Odiez mocno zabrudzona ");
            System.out.println("        5. Plukanie        ");
            System.out.println("      6. Odwirowywanie     ");
            System.out.println("         7. Custom         ");
            System.out.println("         8. Wylacz         ");
            System.out.println("---------------------------");
            System.out.print("Opcja: ");
        }

        public void Wybor() throws InterruptedException {
            Scanner scanner = new Scanner(System.in);
            int czas;
            int wybor = scanner.nextInt();
            switch(wybor){
                case 1:
                    this.grzalka.ustawTemp(60);
                    this.regulatorPredkosci.ustawObroty(700);
                    czas = 30;
                    FiltrWody.zywotnosc -=1;
                    WyswietlWybor(wybor, grzalka.wartosc, regulatorPredkosci.wartosc, czas);
                    Potwierdzenie(czas);
                    break;

                case 2:
                    this.grzalka.ustawTemp(30);
                    this.regulatorPredkosci.ustawObroty(600);
                    czas = 60;
                    FiltrWody.zywotnosc -=1;
                    WyswietlWybor(wybor, grzalka.wartosc, regulatorPredkosci.wartosc, czas);
                    Potwierdzenie(czas);
                    break;

                case 3:
                    this.grzalka.ustawTemp(60);
                    this.regulatorPredkosci.ustawObroty(700);
                    czas = 75;
                    FiltrWody.zywotnosc -=1;
                    WyswietlWybor(wybor, grzalka.wartosc, regulatorPredkosci.wartosc, czas);
                    Potwierdzenie(czas);
                    break;

                case 4:
                    this.grzalka.ustawTemp(90);
                    this.regulatorPredkosci.ustawObroty(800);
                    czas = 90;
                    FiltrWody.zywotnosc -=1;
                    WyswietlWybor(wybor, grzalka.wartosc, regulatorPredkosci.wartosc, czas);
                    Potwierdzenie(czas);
                    break;

                case 5:
                    this.grzalka.ustawTemp(30);
                    this.regulatorPredkosci.ustawObroty(600);
                    czas = 60;
                    WyswietlWybor(wybor, grzalka.wartosc, regulatorPredkosci.wartosc, czas);
                    Potwierdzenie(czas);
                    break;

                case 6:
                    this.grzalka.ustawTemp(0);
                    this.regulatorPredkosci.ustawObroty(900);
                    czas = 30;
                    WyswietlWybor(wybor, grzalka.wartosc, regulatorPredkosci.wartosc, czas);
                    Potwierdzenie(czas);
                    break;

                case 7:
                    System.out.println("Podaj temperature (C): ");
                    this.grzalka.ustawTemp(scanner.nextInt());
                    System.out.println("Podaj ilosc obrotow na min: ");
                    this.regulatorPredkosci.ustawObroty(scanner.nextInt());
                    System.out.println("Podaj czas (min): ");
                    czas = scanner.nextInt();
                    FiltrWody.zywotnosc -=1;
                    WyswietlWybor(wybor, grzalka.wartosc, regulatorPredkosci.wartosc, czas);
                    Potwierdzenie(czas);
                    break;

                case 8:
                    Zakoncz();
                    System.out.println("Do widzenia");
                    break;
            }

            scanner.close();
        }

        public void Start() throws InterruptedException {
            POST();
            Menu();
            Wybor();
        }

        public void WyswietlWybor(int wybor, int temp, int obroty, int czas){
            System.out.println("---------------------------");
            System.out.println("Wybrano " + wybor + " tryb o ustawieniach: ");
            System.out.println("Temperatura: " + temp + " (stopni C)");
            System.out.println("Obroty/min: " + obroty);
            System.out.println("Czas: " + czas + " (min)");
            System.out.println("---------------------------");
        }

        public void Potwierdzenie(int czas) throws InterruptedException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Czy rozpoczac prace? (1/0)");
            int x = scanner.nextInt();
            if(x == 0){
                Anuluj();
            } else if(x == 1){
                Rozpocznij(czas);
            }
        }

        public void Anuluj() throws InterruptedException {
            System.out.println("Pranie anulowane...");
            Menu();
            Wybor();
        }

        public void Rozpocznij(int czas) throws InterruptedException {
            double procent = (double)czas/100;
            System.out.println("Pranie rozpoczete...");

            System.out.print("[");
            for(double x=0; x<czas*10; x+=procent*10) {
                Thread.sleep(czas*100L);
                System.out.print("=");
                if(!FatalErrorSim()){
                    System.out.println();
                    POST();
                    break;
                }
                if(x==(czas*10)-(procent*10))System.out.print("]");
            }
            System.out.println();
            Zakoncz();
        }

        public void Zakoncz() {
            System.out.println("Pranie zakonczone...");
        }

        public boolean FatalErrorSim(){
            int random = (int)(Math.random()*(200))+1;
            if(random==200){
                int random2 = (int)(Math.random()*(7-1))+1;
                switch(random2){
                    case 1:
                        elektrozawor.isWorking=false;
                        break;
                    case 2:
                        grzalka.isWorking=false;
                        break;
                    case 3:
                        pojemnikDetergenty.isWorking=false;
                        break;
                    case 4:
                        filtr.isWorking=false;
                        break;
                    case 5:
                        pompa.isWorking=false;
                        break;
                    case 6:
                        regulatorPredkosci.isWorking=false;
                        break;
                    case 7:
                        silnikInwerterowy.isWorking=false;
                        break;
                }
                return false;
            }
            return true;
        }

    }

    public static void main(String[] args) throws InterruptedException {
         ElektrozaworyWodne elektrozawor = new ElektrozaworyWodne(0,true);
         FiltrWody filtr = new FiltrWody(500,400,true);
         GrzalkaWody grzalka = new GrzalkaWody(0, true);
         PojemnikUbran pojemnikUbrania = new PojemnikUbran(10,true);
         PojemnikDetergenty pojemnikDetergenty= new PojemnikDetergenty(1000, true);
         PompaWody pompa = new PompaWody(2000,true);
         RegulatorPredkosci regulatorPredkosci = new RegulatorPredkosci(0, true);
         SilnikInwerterowy silnikInwerterowy = new SilnikInwerterowy(0, true);

        Pralka pralka = new Pralka(elektrozawor,filtr,grzalka,pojemnikUbrania,pojemnikDetergenty,pompa,regulatorPredkosci,silnikInwerterowy);
        pralka.Start();
    }
}