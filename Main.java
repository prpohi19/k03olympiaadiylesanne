import java.io.*;
import java.util.*;

/*
https://www.teaduskool.ut.ee/sites/default/files/teaduskool/olympiaad/eesti/eio_2011_12_ev_ylesanded_eesti.pdf
*/
public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");
        BufferedReader lugeja = new BufferedReader(new FileReader("histo.txt"));
        PrintWriter kirjutaja = new PrintWriter(new FileWriter("v2lja.txt"));
        int kogus = Integer.parseInt(lugeja.readLine());
        String[] s6nad = new String[4];
        String line;
        String t2hestik = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int counter = 0;
        for (int i = 0; i < kogus; i++) {
            line = lugeja.readLine();
            //line = line.replaceAll("\\s", "");
            if (line.contains(" ")){
                String helper [] = line.split(" ");
                s6nad[counter]= helper[0];
                counter++;
                s6nad[counter]= helper[1];
                counter++;

            } else {s6nad[counter] = line; counter++;}
            //System.out.println(s6nad[i] + " " + s6nad[i].length());
        }
        System.out.println(Arrays.toString(s6nad));
        int t2ht = 0;
        int t2ht1 = 0;
        int t2ht2 = 0;

        for (int k = 0; k < counter; k++) {
            String s6na = s6nad[k];
            for (int u = 0; u < t2hestik.length(); u++) {


                for (int l = 0; l < s6na.length(); l++) {
                    //System.out.println(s6na.charAt(l) + " " + l);

                    if (s6na.charAt(l) == t2hestik.charAt(u)) {
                        if (Character.toString(t2hestik.charAt(u)).matches("A")) {
                            t2ht++;
                        } else if (Character.toString(t2hestik.charAt(u)).matches("B")) {
                            t2ht1++;
                        } else if (Character.toString(t2hestik.charAt(u)).matches("C")) {
                            t2ht2++;
                        }


                    }
                    //if (0<t2ht){ }
                    System.out.println(t2hestik.charAt(u) + " " + t2ht + "B " + t2ht1 + " C " + t2ht2);
                }
            }

            //System.out.println(s6na.charAt(k));
        }
        kirjutaja.println("A "+t2ht);
        kirjutaja.println("B "+t2ht1);
        kirjutaja.println("C "+t2ht2);
        lugeja.close();
        kirjutaja.close();
    }
}
