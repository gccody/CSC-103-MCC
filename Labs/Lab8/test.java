package Labs.Lab8;

public class test {
    public static void main(String[] args) {
        binaryPrint(27);
    }

    //convert decimal number to binary
    public static void binaryPrint(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            binaryPrint(n / 2);
            System.out.print(n % 2);
        }
    }
}