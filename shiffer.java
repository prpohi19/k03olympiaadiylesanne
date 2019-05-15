import java.io.*;
import java.util.*;

public class shiffer {
    public static void main(String[] args) throws IOException {
        int shift = -4;
        try (Scanner input = new Scanner(new File("tekstsisend.txt"));
                PrintStream output = new PrintStream(new File("valjund.txt"))) {
            while (input.hasNextLine()) {
                output.println(tekst(input.nextLine(), shift));
            }
        }
    }


    public static String tekst(String text, int shift) {
        shift %= 26; //shift = shift % 60
        if (shift == 0) return text;
        StringBuilder sb = new StringBuilder(text.length());
        for (int n = 0; n < text.length(); n++) {
            int a = text.charAt(n);

            if (a >= 'A' && a <= 'Z') {
                a += shift; // a= a+shift
                if (a > 'Z') a -= 26;
            } else if (a >= 'a' && a <= 'z') {
                a += shift;
                if (a > 'z') a -= 26;
            }

            sb.append((char) a);
        }
        return sb.toString();
    }
}

/* Spm qiiphmz xyxzyhe.
Räiqi lsqqi õlxyp.

Oli meeldiv tutvuda.
Näeme homme õhtul.

*/
