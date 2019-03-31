import java.util.*;
import java.io.*;
public class Copy
{
   public static void main(String args[]) throws Exception
   {
     String loetud, tagurpidi = "";
     BufferedReader lugeja = new BufferedReader(new FileReader("PalindroomTest.txt"));
     loetud = lugeja.readLine();

     int suurus = loetud.length();
      for(int j = suurus - 1; j >= 0; j--)
      {
         tagurpidi = tagurpidi + loetud.charAt(j);//keerab tagurpidi
      }
      System.out.println("Loetud tekst: "+loetud);
      System.out.println("Failis olev kirje tagurpidi: "+tagurpidi);

      PrintWriter writer = new PrintWriter(new FileWriter("Tulemus.txt"));

      if(loetud.equals(tagurpidi))
      {
          writer.println("Filist loetud kirje: "+"'"+loetud+"' "+"on palindroom.");
          System.out.println("Failis olev kirje on palindroom");

      }
      else
      {
          writer.println("Failist loetud kirje: "+"'"+loetud+"' "+"pole palindroom.");
          System.out.println("Failis olev kirje ei ole palindroom");
      }
      writer.close();
   }
}
