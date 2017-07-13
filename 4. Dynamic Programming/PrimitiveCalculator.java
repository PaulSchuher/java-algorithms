import java.util.*;
import java.util.Arrays;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[] countSequence = count_sequence(n);
        int intermediate = n;
        sequence.add(intermediate);
        for(int i=countSequence[n-1]; i>0; i--) {
            intermediate = calculate_intermediate(intermediate, countSequence, i);
            sequence.add(intermediate);
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static int[] count_sequence(int n) {
        int[] seq = new int[n];
        seq[0] = 0;
        for (int i=1; i < n; i++) {
            int digit = i+1;
            seq[i] = calculate_count(digit, seq);
        }
        return seq;
    }

    private static int calculate_count(int digit, int[] sequence) {
        int min = digit;
        if (digit % 3 == 0) {
            int v = sequence[digit/3 - 1] + 1;
            if (v < min) {
                min = v;
            }
        }
        if (digit % 2 == 0) {
            int v = sequence[digit/2 - 1] + 1;
            if (v < min) {
                min = v;
            }
        }
        int v = sequence[digit-2] + 1;
        if (v < min) {
            min = v;
        }
        return min;
    }

    private static int calculate_intermediate(int digit, int[] seq, int n) {
        if (digit % 3 == 0) {
            int v = digit / 3;
            if (v > 0 && seq[v-1] == (n-1)) {
                return v;
            }
        }
        if (digit % 2 == 0) {
            int v = digit / 2;
            if (v > 0 && seq[v-1] == (n-1)) {
                return v;
            }
        }
        return digit - 1;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

