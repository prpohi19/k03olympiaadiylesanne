import java.io.*;
import java.util.*;
/* Kirjutada programm, mis kontrollib, kas kaks ristkulikukujulist kipsplaati on 
võimalik asetada üksteise peale nii, et ülemine plaat ei ulatu üle alumise ääre. */
public class k03olympiaad{
	public static void main(String[] arg) throws Exception{
    BufferedReader reader = new BufferedReader(new FileReader("kipssis.txt"));
    PrintWriter writer=new PrintWriter(new FileWriter("kipsval.txt"));
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
    /* Tekstifaili kips.val ainsale reale väljastada:
    kui plaate pole võimalik nõutud viisil üksteise peale asetada, väljastada EI SAA. 
    Kui esimese plaadi saab asetada teise peale, väljastada 2 1; 
    Kui teise plaadi saab asetada esimese peale, väljastada 1 2*/
    if((plaat1pikkus >= plaat2pikkus) && (plaat1laius >= plaat2laius)) {
      System.out.println("1 2");
      writer.println("1 2");

    } else if ((plaat2pikkus >= plaat1pikkus) && (plaat2laius >= plaat1laius)) {
      System.out.println("2 1");
      writer.println("2 1");
    } else {
      System.out.println("EI SAA");
      writer.println("EI SAA");
    }
    writer.close();
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
