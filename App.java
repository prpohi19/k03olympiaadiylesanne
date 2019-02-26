import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * App
 */
public class App
{

    public static void main(String[] args) throws Exception {
        App app = new App();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("kata.sis"));
        Directory root = new Directory("/");
        int lines = Integer.parseInt(bufferedReader.readLine());
        if (lines == 0) {
            bufferedReader.close();
            return;
        }

        Directory current = root;
        Directory lastChild = root;
        int step = 0;

        // Build directory tree
        String line = bufferedReader.readLine();
        while (line != null) {

            // Count the spaces in the beginning
            int newStep = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != ' ') {
                    newStep = i;
                    break;
                }
            }

            Directory newDirectory = new Directory(line.trim());
            if (step == -1 || newStep == step) {
                newDirectory.setParent(current);
                current.addChild(newDirectory);
                lastChild = newDirectory;
            } 
            else if (newStep > step) {
                newDirectory.setParent(lastChild);
                lastChild.addChild(newDirectory);
                current = lastChild;
                lastChild = newDirectory;
            }
            else {
                // Protect for incorrect tree where the first item isn't in root position
                if (current.getParent() != null) {
                    current = current.getParent();
                }

                // Not needed for the exercise
                /* for (int back = step - newStep; back >= 0; back--) {
                    current = current.getParent();
                } */

                newDirectory.setParent(current);
                current.addChild(newDirectory);
                lastChild = newDirectory;
            }

            step = newStep;
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        app.saveResult("kata.out", root);
    }

    // Build the tree representation and store it to a file
    public void saveResult(String filename, Directory root) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(filename), "utf-8"))) {

            // Since we don't want to show root ("/") as the first directory 
            // (in the excercise there can be multiple root dirs),
            // we get each child of root ("/") individually.
            for (Directory dir : root.getChilds()) {
                dir.setParent(null);
                String tree = dir.getTree();
                writer.write(tree);
                System.out.print(tree);
            }
        }
    }
}
