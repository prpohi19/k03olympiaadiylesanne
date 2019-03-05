
import java.io.*;
import java.util.*;

public class caezar {
    public static void main(String[] args) throws IOException {
        int shift = -2;
        try (Scanner input = new Scanner(new File("cssis.txt")); 
                PrintStream output = new PrintStream(new File("csval.txt"))) {
            while (input.hasNextLine()) {
                output.println(caesar(input.nextLine(), shift));
            }
        }
    }

    public static String caesar(String text, int shift) {
        shift %= 26;
        if (shift == 0) return text;
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c += shift;
                if (c > 'Z') c -= 26;
            } else if (c >= 'a' && c <= 'z') {
                c += shift;
                if (c > 'z') c -= 26;
            }

            sb.append((char) c);
        }
        return sb.toString();
    }
}