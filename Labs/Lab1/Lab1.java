package Labs.Lab1;
import java.util.Scanner;

class Lab1 {
  public static void main(String[] args) {
    Scanner k = new Scanner(System.in);
    int[] arr = new int[100];
    int sum = 0;
    int numInputed = 0;

    while (true){
      System.out.print("Enter a positive number (-1 to exit): ");
      int ans = k.nextInt();

      if (ans == -1){
        break;
      }
      if (ans < 0) {
        System.out.println("Enter a number greater then 0");
        continue;
      }
      sum += ans;
      arr[numInputed] = ans;
      numInputed++;
    }
    k.close();

    System.out.println("Number of inputs received: " + Integer.toString(numInputed));
    System.out.println("The average value is: " + Integer.toString(averageValue(sum, numInputed)));
    System.out.println("The highest value is: " + Integer.toString(highestValue(arr)));
  }
  
  public static int highestValue(int[] arr){
    int highest = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > highest){
        highest = arr[i];
      }
    }
    return highest;
  }

  public static int averageValue(int sum, int numInputed){
    return sum/numInputed;
  }
}