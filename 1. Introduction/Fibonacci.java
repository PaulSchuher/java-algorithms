import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1) {
      return n;
    }

    int nm1 = 0;
    int nm2 = 1;

    for(int i=2; i <= n; ++i) {
      int sum = nm1 + nm2;
      nm1 = nm2;
      nm2 = sum;
    }
    return nm2;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
