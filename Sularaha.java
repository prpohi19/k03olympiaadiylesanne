//https://www.teaduskool.ut.ee/sites/default/files/teaduskool/olympiaad/eesti/eio_2010_11_ev_ylesanded_eesti.pdf Y2

import java.io.*;

public class Sularaha {
    public static void main(String[] arg) throws Exception {
        int i = 0;
        BufferedReader lugeja=new BufferedReader(new FileReader("C:\\Users\\Urmot\\IdeaProjects\\Sularaha\\src\\raha.sis"));
        int[] sularaha = new int[]{ 1,2,5,10,25,50,100,500 };
        int suurus=Integer.parseInt(lugeja.readLine());
        int j22k = suurus;
        int vastus = 0;
        int t = 1;
        while (true){
            int k = i;
            if(sularaha[i] > suurus){
                break;
            }
            t=1;
            while(t*sularaha[i] <= suurus) {
                if(i==0){
                    t=suurus;
                }
                for (int s = 0; s < t; s++) {
                    if (sularaha[i] < j22k) {
                        System.out.print(sularaha[i] + " + ");
                    } else if (sularaha[i] == j22k) {
                        System.out.print(sularaha[i]);
                    }
                    j22k -= sularaha[i];
                } while (j22k > 0) {
                    if(k>=1) {
                        k -= 1;
                    }
                    while (sularaha[k] <= j22k) {
                        if (sularaha[k] < j22k) {
                            System.out.print(sularaha[k] + " + ");
                        } else {
                            System.out.print(sularaha[k]);
                        }
                        j22k -= sularaha[k];
                    }
                }
                System.out.println();
                j22k = suurus;
                t++;
                vastus+=1;
            }
            i++;
        }
        System.out.println("Kokku on "+vastus+ " võimalikku makseviisi");
    }
}