import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class olumpiaadikodotoo  {


    public void findNumbers() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sHein\\IdeaProjects\\kodutoo03-Sander\\src\\input.txt"));

    String current = reader.readLine();

    String[] split = current.split(" ");
    int amount = Integer.parseInt(split[0]);
    int sum = Integer.parseInt(split[1]);
    String[] placeHolder = new String[amount];

    List<String> solution = new ArrayList<String>();

         for(int i = 0; i < amount; i++){
        placeHolder[i] = reader.readLine();
    }
        for(int i = 0; i < amount; i++){
        for(int j = 0; j < amount; j++){
            if(Integer.parseInt(placeHolder[i]) + Integer.parseInt(placeHolder[j]) == sum && placeHolder[i] != placeHolder[j]){
                solution.add(placeHolder[i] + " + " + placeHolder[j]);
            }
        }
    }
        System.out.println(solution.size()/2);
        for (int i = 0; i < solution.size()/2; i++){
            System.out.println(solution.get(i));
    }
}

}
