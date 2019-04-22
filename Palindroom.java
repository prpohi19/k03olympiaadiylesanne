import java.util.*;
import java.io.*;

public class Palindroom{
	public static void main(String[] arg) throws Exception {
		BufferedReader reader =  new BufferedReader(new FileReader("sisend.txt"));
		String line = reader.readLine();
		String check = "";
		
		for (int i = line.length()-1; i >= 0 ; i--){
			check += line.charAt(i);
		}
		System.out.println("Sisend: " + line);
		System.out.println("Tagurpidi: " + check);
		
		PrintWriter writer = new PrintWriter(new FileWriter("valjund.txt"));
		if(check.equals(line)){
			System.out.println("On palindroom");
			writer.println(line + " - on palindroom");
		}
		else{
			System.out.println("Ei ole palindroom");
			writer.println(line + " - ei ole palindroom");
		}
		writer.close();
	}
}