import java.util.*;
import java.io.*;
public class Palidroom{
    public static void main(String[] args) throws Exception{
    String loetud, tagurpidi = "";
    BufferedReader lugeja = new BufferedReader(new FileReader("pal.txt"));
    loetud = lugeja.readLine();
    int suurus = loetud.length();
    for(int j = suurus - 1; j >= 0; j--){
        tagurpidi = tagurpidi + loetud.charAt(j);
    }
    System.out.println("Loetud failist: "+loetud);
    System.out.println("Tagurpidi: "+tagurpidi);
    PrintWriter writer = new PrintWriter(new FileWriter("valjund.txt"));
    if(loetud.equals(tagurpidi)){
        writer.println(loetud+" on palindroom.");
    }else{
        writer.println(loetud+" pole palindroom.");
    }
    lugeja.close();
    writer.close();
    }
}

/*
OUTPUT
Loetud failist: 1331
Tagurpidi: 1331
*/
