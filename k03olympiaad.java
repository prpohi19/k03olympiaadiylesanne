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
    int plaat1pikkus = Integer.parseInt(plaat1[0]);
    int plaat1laius = Integer.parseInt(plaat1[1]);
    int plaat2pikkus = Integer.parseInt(plaat2[0]);
    int plaat2laius = Integer.parseInt(plaat2[1]);

    System.out.println("Esimese plaadi mõõt on " + plaat1pikkus + "x" + plaat1laius);
    System.out.println("Teise plaadi mõõt on " + plaat2pikkus + "x" + plaat2laius);
    if((plaat1pikkus >= plaat2pikkus) && (plaat1laius >= plaat2laius)) {
      System.out.println("1 2");

    } else if ((plaat2pikkus >= plaat1pikkus) && (plaat2laius >= plaat1laius)) {
      System.out.println("2 1");
    } else {
      System.out.println("EI SAA");
    }
    reader.close();
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
