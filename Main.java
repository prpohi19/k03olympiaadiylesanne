import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader luger = new BufferedReader(new FileReader("C:\\Users\\Inimene\\Desktop\\Palindroom1.txt"));
        String loetud, tagurpidi = "";
        loetud = luger.readLine();



        int suurus = loetud.length();
        for(int j = suurus - 1; j >= 0; j--)
        {


            tagurpidi = tagurpidi + loetud.charAt(j);
        }
        System.out.println("Failis olev kirje tagurpidi: "+tagurpidi);

        PrintWriter writer = new PrintWriter(new FileWriter("Tulemus.txt"));

        if(loetud.equals(tagurpidi))
        {
            writer.println("Failis olev fraas: "+"'"+loetud+"' "+"on palindroom.");
            System.out.println("Failis olev fraas on palindroom");

        }
        else
        {
            writer.println("Failist olev fraas: "+"'"+loetud+"' "+"pole palindroom.");
            System.out.println("Failis olev fraas pole palindroom");
        }
        writer.close();
    }
}