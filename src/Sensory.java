import java.util.ArrayList;
import java.util.List;
public class Sensory {
    public boolean wszystkoSprawne = true;
    public List<String> zepsuteSensory = new ArrayList<>();

    Sensory(boolean elektrozaworSprawna, boolean grzalkaSprawna, boolean pojemnikDetergentySprawna,
            boolean filtrSprawna,boolean pompaSprawna,
            boolean regulatorPredkosciSprawna, boolean SilnikInwerterowySprawna){
        if(!elektrozaworSprawna){
            this.zepsuteSensory.add("Elektrozawory wodne");
            this.wszystkoSprawne = false;
        }
        if(!grzalkaSprawna){
            this.zepsuteSensory.add("Grzalka wody");
            this.wszystkoSprawne = false;
        }
        if(!pojemnikDetergentySprawna){
            this.zepsuteSensory.add("Pojemnik na detergetny");
            this.wszystkoSprawne = false;
        }
        if(!filtrSprawna){
            this.zepsuteSensory.add("Filtr wody");
            this.wszystkoSprawne = false;
        }
        if(!pompaSprawna){
            this.zepsuteSensory.add("Pompa wodna");
            this.wszystkoSprawne = false;
        }
        if(!regulatorPredkosciSprawna){
            this.zepsuteSensory.add("Regulator predkosci");
            this.wszystkoSprawne = false;
        }
        if(!SilnikInwerterowySprawna){
            this.zepsuteSensory.add("Silnik inwerterowy");
            this.wszystkoSprawne = false;
        }
    }

    public boolean SprawdzSensory(){
        if(!wszystkoSprawne){
            System.out.println("Napotkane bledy: " + zepsuteSensory.toString());
        }
        return wszystkoSprawne;
    }
}
