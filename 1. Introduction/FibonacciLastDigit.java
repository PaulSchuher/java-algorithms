import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
      if (n <= 1) {
        return n;
      }

      int nm1 = 0;
      int nm2 = 1;

      for(int i=2; i <= n; ++i) {
        int sum = nm1 + nm2;
        nm1 = nm2;
        nm2 = sum % 10;
      }
      return nm2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

