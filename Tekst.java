import java.io.*;
import java.util.*;

public class Tekst{
  public static void main(String[] args) throws Exception{
    //Faili lugemine
    BufferedReader lugeja = new BufferedReader(new FileReader("input1.txt"));
    List<String> hoidla = new ArrayList<String>();
    String rida = lugeja.readLine();
    while(rida != null){
      hoidla.add(rida);
      rida = lugeja.readLine();
    }
    List<String> sarnased = new ArrayList<String>();
    String otsi = (hoidla.get(hoidla.size()-1).replaceAll("\\*","."));
    System.out.println(otsi);
    hoidla.remove(hoidla.size()-1);

    int loendur = 0;
    for (String failiRida : hoidla){
      if (failiRida.matches(otsi)){
        sarnased.add(failiRida);
        loendur += 1;
      }
    }

    //Faili kirjutamine

    PrintWriter kirjutaja = new PrintWriter(new FileWriter("vastus2.txt"));
    kirjutaja.println(loendur);

    for (String tulemus : sarnased){
      kirjutaja.println(tulemus);
    }
