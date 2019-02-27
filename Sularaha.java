//https://www.teaduskool.ut.ee/sites/default/files/teaduskool/olympiaad/eesti/eio_2010_11_ev_ylesanded_eesti.pdf Y2

import java.io.*;

public class Sularaha {
    public static void main(String[] arg) throws Exception {
        int i = 0;
        BufferedReader lugeja=new BufferedReader(new FileReader("C:\\Users\\Student Admin\\eclipse-workspace\\Tekst\\src\\raha.sis"));
        int[] sularaha = new int[]{ 1,2,5,10,25,50,100,500 };
        int suurus=Integer.parseInt(lugeja.readLine());
        int j22k = suurus;
        int vastus = 0;
        int t = 1;
        int l = 1;
        int algne_k = 0;
        int proov = 0;
        int k = i;
        while (true){
            if(sularaha[i] > suurus){
                break;
            }
            else if(k == 0|| l*sularaha[algne_k] >= proov) {
            	t=1;
            	l=1;
            }
            while(t*sularaha[i] <= suurus) {
            	k = i;
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
                    proov = j22k;
                } while (j22k > 0) {
                    if(k>=1) {
                        k -= 1;
                        algne_k = k;
                    }
                    if(l*sularaha[k] <= j22k) {
                    	for (int s = 0; s < l; s++) {
                           if (sularaha[k] < j22k) {
                               System.out.print(sularaha[k] + " + ");
                           } else if (sularaha[k] == j22k) {
                               System.out.print(sularaha[k]);
                           }
                           j22k -= sularaha[k];
                    	}
                    }
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
                l++;
                if(l*sularaha[algne_k] <= proov && algne_k >= 1) {
                	k=algne_k;
                } else {
                	t++;
                }
                vastus+=1;
            }
            i++;
        }
        System.out.println("Kokku on "+vastus+ " vÃµimalikku makseviisi");
    }
}
