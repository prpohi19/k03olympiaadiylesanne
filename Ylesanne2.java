import java.io.*;
import java.util.*;
import java.lang.Math;

public class Ylesanne2{
  public static void main(String[] arg)throws Exception{
    BufferedReader reader = new BufferedReader(new FileReader("tekstsis2.txt"));
    int count = Integer.parseInt(reader.readLine());
    String rida;
    String[] strings = new String[99];
    int[] results = new int[count];
    String number = "";
    int number2;


     for(int i=0; i<count; i++){
        rida = reader.readLine();

        for(int j=0; j<rida.length();j++){
          if(rida.charAt(j) != '|'){
              if(Character.isUpperCase(rida.charAt(j)) == true){
                //System.out.println("1");
                //strings[j] = "1";
                number = number + "1";
              }else{
                  //System.out.println("0");
                  //strings[j] = "0";
                  number = number + "0";
              }
          }else{
            break;
          }
        }
        number2 = Integer.parseInt(number);
        //System.out.println(number);
        results[i] = Integer.parseInt(number, 2);
        number = "";
        //results[i] = number;
     }
     PrintWriter writer = new PrintWriter(new FileWriter("tekstval2.txt"));
     for(int i=0; i<count;i++){
        writer.println(results[i]);
     }
     writer.close();
     reader.close();
  }
}
