import java.util.*;
import java.io.*;
public class Copy{
//https://www.teaduskool.ut.ee/sites/default/files/teaduskool/olympiaad/eesti/eio_2006_07_pv_ylesanded_eesti.pdf
   public static void main(String args[]) throws Exception{
     String loetud, tagurpidi = "";

     BufferedReader lugeja = new BufferedReader(new FileReader("palsis.txt"));
     loetud = lugeja.readLine();//loeb faili ja teeb stringiks
    // int arv = Integer.parseInt(original); stringi teeb integeriks
     int suurus = loetud.length();//saab failis oleva kirje tähtede arvu
      for(int j = suurus - 1; j >= 0; j--){
         tagurpidi = tagurpidi + loetud.charAt(j);//keerab tagurpidi
      }
      System.out.println("Loetud tekst: "+loetud);
      System.out.println("Tagurpidi keeratud kirje: "+tagurpidi);

      PrintWriter writer = new PrintWriter(new FileWriter("palval.txt"));

      if(loetud.equals(tagurpidi)){
          writer.println("Loetud kirje: "+"'"+loetud+"' "+"on palindroom.");
      }else{
          writer.println("Loetud kirje: "+"'"+loetud+"' "+"pole palindroom.");
      }
      writer.close();
   }
}
