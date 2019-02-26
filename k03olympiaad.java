import java.io.*;
import java.util.*;

public class k03olympiaad{
	public static void main(String[] arg) throws Exception{
    BufferedReader reader = new BufferedReader(new FileReader("kipssis.txt"));
    System.out.println("Kontroll kas antud kipsplaate saab üksteise otsa panna");
    String rida;
    String[] plaat1;
    String[] plaat2;

    rida = reader.readLine();
    plaat1 = rida.split(" ");
    rida = reader.readLine();
    plaat2 = rida.split(" ");
    int abi1 = Integer.parseInt(plaat1[0]);
    int abi2 = Integer.parseInt(plaat1[1]);
    int abi3 = Integer.parseInt(plaat2[0]);
    int abi4 = Integer.parseInt(plaat2[1]);

    System.out.println("Esimese plaadi mõõt on " + plaat1[0] + "x" + plaat1[1]);
    System.out.println("Teise plaadi mõõt on " + plaat2[0] + "x" + plaat2[1]);
    if((abi1 >= abi3) && (abi2 >= abi4)) {
      System.out.println("1 2");

    } else if ((abi3 >= abi1) && (abi4 >= abi2)) {
      System.out.println("2 1");
    } else {
      System.out.println("EI SAA");
    }
	}
}

/* TULEMUS
Kontroll kas antud kipsplaate saab üksteise otsa panna
Esimese plaadi mõõt on 1x4
Teise plaadi mõõt on 2x5
2 1

Kontroll kas antud kipsplaate saab üksteise otsa panna
Esimese plaadi mõõt on 1x4
Teise plaadi mõõt on 2x3
EI SAA
*/
