import java.util.*;
import java.math.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1)
            return n;

        List<Long> subsequence = getPisanoSubsequence(n, m);
        return subsequence.get((int)((n % subsequence.size())));
    }

    private static List<Long> getPisanoSubsequence(long n, long m) {
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
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

