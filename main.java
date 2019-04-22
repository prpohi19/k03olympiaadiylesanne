import java.io.IOException;

public class main {

    public static void main(String[] args) {

        olumpiaadikodotoo olumpiaadikodotoo1 = new olumpiaadikodotoo();
        try {
            olumpiaadikodotoo1.findNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
