import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Text {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input1.txt"));
        List<String> list = new ArrayList<>();

        String row = reader.readLine();

        while (row != null){
            list.add(row);
            row = reader.readLine();
        }

        PrintWriter writer = new PrintWriter(new FileWriter("output1.txt"));

        String lastValue = list.get(list.size()-1).replaceAll("\\*", ".");
        list.remove(list.size()-1);

        int counter = 0;

        for (String letter: list){
            if (letter.matches(lastValue)){ counter += 1; }
        }

        writer.println(counter);

        for (String letter: list){
            if (letter.matches(lastValue)){ writer.println(letter); }
        }

        writer.close();
    }
}
