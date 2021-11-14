package advprog.stopcost;

public class Vertice {

    // weight
    private int speed;

    // static cost
    private static int signCost;
    private boolean hasSign;

    private Node in;
    private Node out;

    public Vertice(Node in, Node out, int speed) {
        this.in = in;
        this.out = out;
        this.hasSign = false;
        this.speed = speed;
    }

    public Node getIn() {
        return in;
    }

    public Node getOut() {
        return out;
    }

    public int getSpeed() {
        return this.speed;
    }
    /**
     * Upgrades speed
     * @param target
     * @return cost of upgrade
     * @throws IllegalArgumentException
     */
    public int upgradeSpeed(int target) throws IllegalArgumentException {
        if (target < speed) {
            throw new IllegalArgumentException("Can not decrease speed.");
        }

        int cost = target - this.speed;
        this.speed = target;

        return cost;
    }

    public void putSign() {
        this.hasSign = true;
    }
}
