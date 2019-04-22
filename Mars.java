import java.io.*;
import java.util.Scanner;
public class Mars
{
	public static void main(String[] args)
	{
		try
        {

		FileReader file = new FileReader("in.txt");
		FileWriter file2 = new FileWriter("out.txt");
		BufferedReader reader = new BufferedReader(file);
 		BufferedWriter out = new BufferedWriter(file2);

		String line = reader.readLine();

		Scanner s = new Scanner(line);
		int a = s.nextInt();
		int b = s.nextInt();
		int m = 0;
		int k = 1;
		int p = 1;
		int i = 1;
		while (i <= b)
		{
			if (i >= a)
			{
				m += p;
			}
			i += 1;
			p += 1;
			if (p > k)
			{
				k += 1;
				p = 1;
			}
		}
		out.write(m + "\n");
		out.close();
		} 
        catch (IOException excpt) 
        { 
            excpt.printStackTrace(); 
        } 
	}
}
