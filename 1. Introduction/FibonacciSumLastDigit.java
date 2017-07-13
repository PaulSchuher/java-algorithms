import java.util.*;
import java.math.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciSum(long n) {
        return getFibonacciHuge(n, 10L);
    }

    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1)
            return n;

        List<Long> subsequence = getPisanoSubsequenceSum(n, m);

        long sum = 0;
        for (int i=0; i <= (int)(n % subsequence.size()); ++i) {
            sum += subsequence.get(i);
        }
        return sum % 10;
    }

    private static List<Long> getPisanoSubsequenceSum(long n, long m) {
        List<Long> subsequence = new ArrayList<Long>();
        subsequence.add(0L);
        subsequence.add(1L);
        if (n <= 1)
            return subsequence;

        BigInteger previous = new BigInteger("0");
        BigInteger current  = new BigInteger("1");

        for (int i = 2; i <= n; ++i) {
            if (i > 2 && subsequence.get(i-1) == 1L && subsequence.get(i-2) == 0L) {
                // Remove 2 start elements from new period started
                subsequence.remove(i-1);
                subsequence.remove(i-2);
                break;
            }
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add(current);
            subsequence.add(current.mod(BigInteger.valueOf(m)).longValue());
        }
        return subsequence;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

