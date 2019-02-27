import java.io.*;
import java.util.*;

/* ASTMELISE SÜSTEEMI KALKULAATOR */

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("input3.txt"));
        PrintWriter printer = new PrintWriter(new FileWriter("valjund.txt"));
        //Astmete arv
        int N = Integer.parseInt(reader.readLine());

        //Astmed millel tulumaks tõuseb
        List<Double> steps = new ArrayList<>();
        //Tulumaksu protsent
        List<Double> perc = new ArrayList<>();

        String line = reader.readLine();
        for(int i = 0; i < N-1; i++){
            steps.add(Double.parseDouble(line.split(" ")[i]));
        }

        line = reader.readLine();
        for(int i = 0; i < N; i++){
            perc.add(Double.parseDouble(line.split(" ")[i]));
        }

        //Klientide arv
        int M = Integer.parseInt(reader.readLine());

        //steps.add(1000000000000000.0);
        for(int i = 0; i < steps.size(); i++){
            System.out.println(steps.get(i));
        }
        for(int i = 0; i < M; i++){
            double tax = 0;
            double clientPay = Double.parseDouble(reader.readLine());
            double remaining = clientPay;

            for(int j = 0; j < N-1; j++) {
                if(remaining - steps.get(j) >= 0){
                    tax += (steps.get(j) * perc.get(j)) / 100;
                    remaining -= steps.get(j);
                }else if(remaining - steps.get(j) < 0){
                    tax += (remaining * perc.get(j)) / 100;
                    remaining = 0;
                }
                if(j == (N-2)) {
                    if (clientPay > steps.get(N - 2)) {
                        tax += (remaining * perc.get(N-1)) / 100;
                        remaining = 0;
                    }
                }

                else if(remaining == 0){
                    break;
                }
            }

            System.out.println(String.format("%.2f",tax));
            printer.println(String.format("%.2f",tax));
        }

        reader.close();
        printer.close();
    }
}

/*INPUT input3.txt :
10
7 8 2 7 8 3 6 7 3
34 28 71 33 100 90 22 70 42 24
10
61
82
96
78
21
74
19
60
35
64

OUTPUT:
28.93
33.97
37.33
33.01
7.36
32.05
6.70
28.69
19.05
29.65 */