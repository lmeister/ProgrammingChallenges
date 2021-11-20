package advprog.test;

public class Main {


    public static void main(String[] args) {
        long i = 0;
        long stopTime = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() <= stopTime) {
            i++;
        }
        System.out.println(i);
    }
}
