import java.util.*;
import java.util.Scanner;

public class DotProduct {
    private static long maxDotProduct(List<Integer> a, List<Integer> b, int n) {
        long result = 0;
        for (int i = 0; i < n; ++i) {
            int maxA = a.get(0);
            int maxAIndex = 0;
            int maxB = b.get(0);
            int maxBIndex = 0;
            for (int j = 0; j < a.size(); ++j) {
                if (a.get(j) > maxA) {
                    maxA = a.get(j);
                    maxAIndex = j;
                }
            }
            a.remove(maxAIndex);
            for (int j = 0; j < b.size(); ++j) {
                if (b.get(j) > maxB) {
                    maxB = b.get(j);
                    maxBIndex = j;
                }
            }
            b.remove(maxBIndex);

            result += (long)maxA * (long)maxB;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            a.add(i, scanner.nextInt());
        }
        List<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            b.add(i, scanner.nextInt());
        }
        System.out.println(maxDotProduct(a, b, n));
    }
}

