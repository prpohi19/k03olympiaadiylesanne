package Kodutöö3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Arvutamine olumpiaadikodotoo1 = new Arvutamine();
        try {
            olumpiaadikodotoo1.findNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
