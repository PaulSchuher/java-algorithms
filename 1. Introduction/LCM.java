import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcm(long a, long b) {
    return (a * b) / gcd(a, b);
  }

  private static long gcd(long a, long b) {
    long big;
    long small;

    if (a > b) {
      big = a;
      small = b;
    } else {
      big = b;
      small = a;
    }

    while(small > 0) {
      long part = big % small;
      big = small;
      small = part;
    }

    return big;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
