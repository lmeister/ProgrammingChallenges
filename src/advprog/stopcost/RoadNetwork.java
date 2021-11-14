package advprog.stopcost;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoadNetwork {

    private Map<Integer, Node> nodeMap;
    int amountOfNodes;
    int costForSign;

    public RoadNetwork(Path input) throws IOException {
        this.nodeMap = new HashMap<Integer, Node>();
        this.nodeMap = initializeNetwork(input);
    }

    private Map<Integer, Node> initializeNetwork(Path input) throws IOException {
        Map<Integer, Node> nodeMap = new HashMap<Integer, Node>(this.nodeMap);

        List<String> lines = Files.readAllLines(input);
        String[] firstLine = lines.get(0).split(" ");
        this.amountOfNodes = Integer.parseInt(firstLine[0]);
        this.costForSign = Integer.parseInt(firstLine[1]);


        for (int i = 1; i < lines.size(); i++) {
            String[] lineFragments = lines.get(i).split(" ");
            int idParent = Integer.parseInt(lineFragments[0]);

            // Create parent if it doesnt exist
            if (!nodeMap.containsKey(idParent)) {
                Node parent = new Node(idParent);
                nodeMap.put(idParent, parent);
            }

            // Create child if it doesnt exist
            int idChild = Integer.parseInt(lineFragments[1]);
            if (!nodeMap.containsKey(idChild)) {
                Node child = new Node(idChild);
                nodeMap.put(idChild, child);
            }

            // Connect parent and child
            int speed = Integer.parseInt(lineFragments[2]);
            System.out.println("Connecting Parent: " + idParent + " and Child: "
                + idChild + " with speed: " + speed);
            nodeMap.get(idParent).addChild(nodeMap.get(idChild), speed);
        }

        return nodeMap;
    }

    public int optimize() {
        int totalCost = 0;

        // Start at the leaves

        // For each node, calculate the cost (downwards) of:
        // 1. putting a sign (Cost of sign * children is added to total cost)
        // 2. Adjusting the speed to match the subsequent roads/incoming road?
        // -> TODO
        // Store the results in some form (memoization) Needed?
        // -> Probably need an equals method for networks? Subtrees are networks in themselves as well?



        return totalCost;
    }

    public void printNetwork() {
        System.out.println("\t" + this.nodeMap.get(1).getId());
        this.nodeMap.get(1).print(0);
    }

}
