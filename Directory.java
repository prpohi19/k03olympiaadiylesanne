import java.util.ArrayList;
import java.util.List;

/**
 * Directory
 */
public class Directory {

    private String name;
    private Directory parent;
    private List<Directory> childs;

    public Directory(String name) {
        this.name = name;
        this.parent = null;
        this.childs = new ArrayList<>();
    }

    // Go through the tree recursively and print each directory.
    public String getTree() {
        String result = "";

        if (this.getParent() != null) {
            Directory current = this.getParent();
            while (current.getParent() != null) {
                if (current.isLastChild()) {
                    result = "  " + result;
                } else {
                    result = "| " + result;
                }
                current = current.getParent();
            }
            
            // Check if current directory is last 
            if (this.isLastChild()) {
                result += "*-";
            } 
            else {
                result += "+-";
            }
        }

        result += name + "\n";
        // Get the childs
        for (int i = 0; i < childs.size(); i++) {
            result += childs.get(i).getTree();
        }
        return result;
    }

    public boolean isLastChild() {
        if (parent.getChilds().get(parent.getChilds().size()-1) == this) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public List<Directory> getChilds() {
        return childs;
    }

    public void addChild(Directory child) {
        childs.add(child);
    }

    public void setChilds(List<Directory> childs) {
        this.childs = childs;
    }
}