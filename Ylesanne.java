import java.io.*;
import java.util.*;
import java.lang.Math;

public class Ylesanne{

  public static void main(String[] arg)throws Exception{
     BufferedReader reader = new BufferedReader(new FileReader("tekstsis.txt"));
     int count = Integer.parseInt(reader.readLine());
     String binary;
     String rida;
     String word = "";

     //System.out.println(count);

     String[] strings = new String[99];
     int[] integers = new int[count];
     String[] results = new String[count];

     for(int i=0; i<count; i++){
       //System.out.println("in loop");
       rida = reader.readLine();
       //System.out.println(rida.charAt(0));
       integers[i] = Integer.parseInt(reader.readLine());
       binary = Integer.toBinaryString(integers[i])+"@_X__000000000000000000000000000";
       System.out.println(binary);

        for(int j=0; j<rida.length();j++){
          
          if(binary.charAt(j) == '@'){
            strings[j] = "|";
            System.out.println(strings[j]);
            word = word + strings[j];
          }

          if(binary.charAt(j) == '1'){

            strings[j] = rida.substring(j,j+1).toUpperCase();
            System.out.println(strings[j]);
            word = word + strings[j];

          }else{
            strings[j] = rida.substring(j,j+1).toLowerCase();
            System.out.println(strings[j]);
            word = word + strings[j];
          }

        }
        System.out.println(word);
        results[i] = word;
        word = "";
        Arrays.fill(strings, null);
     }
     PrintWriter writer = new PrintWriter(new FileWriter("tekstval.txt"));
     for(int i=0; i<count;i++){
        writer.println(results[i]);
     }
     writer.close();
     reader.close();

  }
}
