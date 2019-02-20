import java.io.*;
import java.util.*;

public class Search {
	public static void main(String arg[]) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("tekstsis.txt"));
		List<String> names = new ArrayList<String>();
		String row = reader.readLine();
		String jukuTeema = row;
		
		while(row != null) {
			names.add(row);
			row = reader.readLine();
			if(row != null) jukuTeema = row;
		}
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		PrintWriter writer = new PrintWriter(new FileWriter("tekstval.txt"));
		String modifiedJukuTeema = jukuTeema;
		
		for(String name: names)
		{
			modifiedJukuTeema = jukuTeema;
			int lastSkip = 0;
			boolean foundMatch = false;
			
			if(name.length() == modifiedJukuTeema.length()) {
				
				for (int m = 0; m < modifiedJukuTeema.length(); m++){
					if(modifiedJukuTeema.charAt(m) == '*') {
						for (int i = 0; i < alphabet.length(); i++){
							char c = alphabet.charAt(i);
							if(modifiedJukuTeema.equals(name) && !jukuTeema.equals(modifiedJukuTeema)) {
								writer.println(name);
								System.out.println("Faili lisati: "+modifiedJukuTeema);
								foundMatch = true;
							}
							if(foundMatch) { foundMatch = false; break;}
							
							String editedTeema = modifiedJukuTeema.substring(0,m)+c+modifiedJukuTeema.substring(m+1);
							
							for (int ii = 0; ii < alphabet.length(); ii++){
								char cc = alphabet.charAt(ii);
								for (int mm = 0; mm < modifiedJukuTeema.length(); mm++){
									if(modifiedJukuTeema.charAt(mm) == '*') {
										modifiedJukuTeema = modifiedJukuTeema.substring(0,mm)+cc+modifiedJukuTeema.substring(mm+1);
										if(modifiedJukuTeema.equals(name) && !jukuTeema.equals(modifiedJukuTeema)) {
											foundMatch = true;
										}
									}
								}
								
								if(foundMatch) { foundMatch = false; break;}
								modifiedJukuTeema = editedTeema;
							}
						}
					}	
				}
			}
		}
		writer.close();
	}
}