//Eesti informaatikaolümpiaad Eelvoor 08.12.2018: Ül 1. Kristjan Põldmets

import java.util.*;
import java.io.*;

public class jada {
  public static void main(String[] args)throws Exception{
    BufferedReader sisend = new BufferedReader(new FileReader("summasis.txt"));
    String kogusJaSumma = sisend.readLine();
    String[] eraldi = kogusJaSumma.split(" ");
    int kogus = Integer.parseInt(eraldi[0]);
    int summa = Integer.parseInt(eraldi[1]);
    String[] jada = new String[kogus];
    List<String> vastused = new ArrayList<String>();

    for(int i = 0; i < kogus; i++){
      jada[i] = sisend.readLine();
    }

    for(int i = 0; i < kogus; i++){
      for(int j = 0; j < kogus; j++){
        if(Integer.parseInt(jada[i]) + Integer.parseInt(jada[j]) == summa && jada[i] != jada[j]){
          vastused.add(jada[i] + "+" + jada[j]);
        }
      }
    }

    PrintWriter valjund = new PrintWriter(new FileWriter("summaval.txt"));
    valjund.println(vastused.size()/2);
    for (int i = 0; i < vastused.size()/2; i++){
      valjund.println(vastused.get(i));
    }

    valjund.close();
    sisend.close();
  }
}
