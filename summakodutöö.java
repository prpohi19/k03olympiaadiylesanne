import java.util.*;
import java.io.*;

public class summakodutöö {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Henri Tammo\\IdeaProjects\\kodutooTekst\\sisend"));
        String readerSum = reader.readLine();
        String[] splitter = readerSum.split(" ");
        int amount = Integer.parseInt(splitter[0]);
        int sum = Integer.parseInt(splitter[1]);
        String[] seq = new String[amount];
        List<String> answers = new ArrayList<String>();

        for(int i = 0; i < amount; i++){
            seq[i] = reader.readLine();
        }
        for(int i = 0; i < amount; i++){
            for(int j = 0; j < amount; j++){
                if(Integer.parseInt(seq[i]) + Integer.parseInt(seq[j]) == sum && seq[i] != seq[j]){
                    answers.add(seq[i] + " + " + seq[j]);
                }
            }
        }

        PrintWriter writer = new PrintWriter(new FileWriter("väljund.txt"));
        writer.println(answers.size()/2);
        for (int i = 0; i < answers.size()/2; i++){
            writer.println(answers.get(i));
        }
        writer.close();
    }
}