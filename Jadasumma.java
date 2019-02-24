/*Eesti informaatikaolümpiaad
Eelvoor 08.12.2018

Kirjutada programm, mis leiab, kui palju on jadas A elementide paare, mille summa on S.
Summa peab tulenema jada kahest erinevast elemendist(ei saa olla nt 5 + 5) ja paare ei tohi uuesti üle loendada,
st paaridest 1 + 9 ja 9 + 1 läheb kirja ainult üks.
*/
import java.util.*;
import java.io.*;

public class Jadasumma {
  public static void main(String[] args) throws Exception{
    BufferedReader lugeja = new BufferedReader(new FileReader("summasis.txt"));
    String kogusJaSumma = lugeja.readLine();
    String[] eraldi = kogusJaSumma.split(" ");
    int kogus = Integer.parseInt(eraldi[0]);
    int summa = Integer.parseInt(eraldi[1]);
    String[] jada = new String[kogus];
    List<String> vastused = new ArrayList<String>();

    for(int i = 0; i < kogus; i++){
      jada[i] = lugeja.readLine();
    }
    for(int i = 0; i < kogus; i++){
      for(int j = 0; j < kogus; j++){
        if(Integer.parseInt(jada[i]) + Integer.parseInt(jada[j]) == summa && jada[i] != jada[j]){
          vastused.add(jada[i] + " + " + jada[j]);
        }
      }
    }

    PrintWriter kirjutaja = new PrintWriter(new FileWriter("summaval.txt"));
    kirjutaja.println(vastused.size()/2);
    for (int i = 0; i < vastused.size()/2; i++){
      kirjutaja.println(vastused.get(i));
    }
    kirjutaja.close();
  }
}
/*
summasis.txt   || summaval.txt
5 10              2
1                 1 + 9
3                 3 + 7
5
7
9

*/
