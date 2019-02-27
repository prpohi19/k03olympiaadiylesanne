/* Mitmed programmid kasutavad maleseisude yulesm2rkimiseks Forsyth-Edwardsi notatsiooni,
kus malelaua olekut kirjeldatakse ridade kaupa ylalt alla ja vasakult paremale. Malendeid
t2histavad selles notatsioonis t2hed nende ingliskeelsete nimetuste j2rgi: K — kuningas,
 Q — lipp, B — oda, N — ratsu, R — vanker, P — ettur, kusjuures valgeid malendeid t2histavad
 suured ja musti v2ikesed t2hed. Tyhjade ruutude korral m2rgitakse nende arv numbriga 1...8.
 Ridade eraldajana kasutatakse kaldkriipsu. Kirjutada programm, mis teisendab Forsyth-Edwardsi
 notatsioonis antud seisu selle pseudograaﬁliseks kujutiseks, kus malendeid t2histatakse samade
 t¨ahtede ja t¨uhje ruute punktidega

 näiteks: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR

 rnbqkbnr
 pppppppp
 ........
 ........
 ........
 ........
 PPPPPPPP
 RNBQKBNR




 */

import java.io.*;
import java.util.*;
public class Eio2{
  public static void main(String[] arg) throws Exception {
    String antud;
    List<String> vastus = new ArrayList<String>();

    BufferedReader lugeja = new BufferedReader(new FileReader("maletest.08.sis"));
    PrintWriter kirjutaja = new PrintWriter(new FileWriter("vastus.txt"));
    antud = lugeja.readLine();
    int pikkus = antud.length();

    for(int i=0;i<pikkus;i++){

      if(String.valueOf(antud.charAt(i)).equals("/")){
        vastus.add("\n");
      }else if(Character.isDigit(antud.charAt(i)) == true){
        int mitu = antud.charAt(i) -'0';
        for(int j=0; j<mitu;j++){
          vastus.add(".");
        }
      }else{
        vastus.add(Character.toString(antud.charAt(i)));
      }

    }
    //System.out.println(vastus);
    for(int k=0;k<vastus.size();k++){
      kirjutaja.print(vastus.get(k));
      System.out.print(vastus.get(k));
    }
    kirjutaja.close();

  }
}
