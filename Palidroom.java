import java.util.*;
import java.io.*;
public class Palidroom{
   public static void main(String args[]) throws Exception{
     String loetud, tagurpidi = "";

     BufferedReader reader = new BufferedReader(new FileReader("palsis.txt"));
     loetud = reader.readLine();
     int suurus = loetud.length();
      for(int j = suurus - 1; j >= 0; j--){
         tagurpidi = tagurpidi + loetud.charAt(j);
      }
      System.out.println("Loetud kirje: "+loetud);
      System.out.println("Tagurpidi kirje: "+tagurpidi);

      PrintWriter writer = new PrintWriter(new FileWriter("palval.txt"));

      if(loetud.equals(tagurpidi)){
          writer.println("Kirje: "+"'"+loetud+"' "+"on palindroom.");
          System.out.println("Tegemist on palidroomiga");
      }else{
          writer.println("Kirje: "+"'"+loetud+"' "+"pole palindroom.");
          System.out.println("Tegemist pole palidroomiga");
      }
      writer.close();
   }
}


//https://www.teaduskool.ut.ee/sites/default/files/teaduskool/olympiaad/eesti/eio_2006_07_pv_ylesanded_eesti.pdf
