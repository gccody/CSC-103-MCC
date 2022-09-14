package Labs.Lab2;

public class Test {
    public static void main(String[] args) {
        double boodle = 42567.19;

        System.out.printf("$%9s", String.format("%,9.2f",boodle));
        System.out.print(String.format("$%9s", String.format("%,9.2f", boodle)));
    }
}
