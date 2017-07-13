import java.util.*;
import java.math.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciPartialSum(long from, long to) {
        if (to <= 1)
            return to;

        long sum = 0;

        List<Long> subsequence = getPisanoSubsequenceSum(to, 10L);

        for (int i = (int)(from % subsequence.size()); i <= (int)(to % subsequence.size()); ++i) {
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
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

