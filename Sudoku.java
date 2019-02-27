//https://www.teaduskool.ut.ee/sites/default/files/teaduskool/olympiaad/eesti/eio_2008_09_ev_ylesanded_eesti.pdf

import java.io.*;

public class Sudoku {
    public static void main(String[] arg) throws Exception {
        BufferedReader lugeja=new BufferedReader(new FileReader("C:\\Users\\Urmot\\IdeaProjects\\Sularaha\\src\\sudoku.sis"));
        PrintWriter writer = new PrintWriter("sudoku.val", "UTF-8");
        int[][] tabel = new int[9][9];
        int k , ajutine = 0;
        int vastus = 0;
        int ajutine_vordlus=0;
        int[] t = new int[] {0,0,0,0,0,0,0,0,0};
        String rida=lugeja.readLine();
        for(int i = 0; i<9; i++) {
            String[] m =rida.split(" ");
            for(int a = 0; a<9; a++) {
                tabel[i][a] = Integer.parseInt(m[a]);
            }
            rida=lugeja.readLine();
        }
        for(int i = 0; i<9; i++) {
            k = 0;
            int vordlus = 0;
            while(k < 9) {
                int arv = tabel[i][k];
                while(vordlus < 9) {
                    if(tabel[i][vordlus] == arv) {
                        ajutine+=1;
                    }
                    vordlus++;
                }
                if(ajutine>1) {
                    t[k]=1;
                }
                ajutine=0;
                System.out.print(t[k]);
                vordlus=0;
                k++;
            }
            System.out.println();
            for(k=0; k<9; k++){
                if(t[k]!=0 && vastus < 2){
                    if(vastus == 0){
                        writer.println("VIGA");
                    }
                    vastus++;
                    writer.println((i+1)+" "+(k+1));
                }
            }
            if (vastus >=2){
                writer.close();
                break;
            }
            t = new int[] {0,0,0,0,0,0,0,0,0};
        }
        System.out.println("--------------------------------");
        if(vastus < 2) {
            for (int i = 0; i < 9; i++) {
                k = 0;
                int vordlus = 0;
                while (k < 9) {
                    int arv = tabel[i][k];
                    while (vordlus < 9) {
                        if (tabel[vordlus][k] == arv) {
                            ajutine += 1;
                            ajutine_vordlus = vordlus;
                        }
                        vordlus++;
                    }
                    if (ajutine > 1) {
                        t[k] = ajutine_vordlus;
                    }
                    ajutine = 0;
                    System.out.print(t[k]);
                    vordlus = 0;
                    k++;
                }
                System.out.println();
                for (k = 0; k < 9; k++) {
                    if (t[k] != 0 && vastus == 0) {
                        writer.println("VIGA");
                        vastus++;
                        writer.println((i + 1) + " " + (k + 1));
                        writer.println((t[k]) + " " + (k + 1));
                    }
                }
                if (vastus >= 1) {
                    writer.close();
                    break;
                }
                t = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            }
        }
        if(vastus == 0){
            System.out.println("KORRAS");
        }
    }
}