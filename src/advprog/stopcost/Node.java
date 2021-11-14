package advprog.stopcost;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int id;
    private Vertice incoming;
    private List<Vertice> children;


    /**
     *
     * @param id
     * @param incoming
     */
    public Node(int id, Vertice incoming) {
        this.id = id;
        this.incoming = incoming;
        this.children = new ArrayList<Vertice>();
    }

    /**
     * Used for tree root
     * @param id
     */
    public Node(int id) {
        this.id = id;
        this.children = new ArrayList<Vertice>();
    }

    public void addChild(Node child, int speed) {
        Vertice vertice = new Vertice(this, child, speed);

        this.children.add(vertice);
    }

    public void print(int level) {
        for (Vertice vertice : this.children) {
            Node child = vertice.getOut();
            for (int i = 0; i < level + 1; i++) {
                System.out.print("\t");
            }
            System.out.println("(" + vertice.getSpeed() + ") " + child.getId());
            if (child.children.size() != 0) {
                child.print(level + 1);
            }
        }
    }

    public int getId() {
        return id;
    }
}
