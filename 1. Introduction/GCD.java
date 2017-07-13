import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
    int big;
    int small;

    if (a > b) {
      big = a;
      small = b;
    } else {
      big = b;
      small = a;
    }

    while(small > 0) {
      int part = big % small;
      big = small;
      small = part;
    }

    return big;
  }

  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
