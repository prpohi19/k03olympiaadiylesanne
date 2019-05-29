//ül: https://i.gyazo.com/844ca47b2c7826f25662dbb27a3b255b.png

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader lugeja=new BufferedReader(new FileReader("sonad.sis"));
        List<String> sonad=new ArrayList<String>();
        List<String> otsinguSonad=new ArrayList<String>();
        String rida=lugeja.readLine();
        int sonaCounter=0;
        int otsinguSonaCounter=0;
        int sonadeArv=0;
        int esimeneRida=0;

        while(rida!=null){
            if (esimeneRida==0){
                sonadeArv=Integer.parseInt(rida);
                esimeneRida=1;
            }
            else if (sonaCounter<sonadeArv) {
                sonad.add(rida);
                sonaCounter+=1;
            }
            else if (sonaCounter>sonadeArv){
                otsinguSonad.add(rida);
                otsinguSonaCounter += 1;
            }
            else{
                sonaCounter+=1;
            }
            rida = lugeja.readLine();
        }

        PrintWriter kirjutaja=new PrintWriter(new FileWriter("sonad.val"));
        for (int i=0; i<sonadeArv; i++) {
            if (otsinguSonad.contains(sonad.get(i))) {
                kirjutaja.println("JAH");
            }
            else {
                kirjutaja.println("EI");
            }
        }
        kirjutaja.close();
    }
}
