import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {

        int [] matrix = new int[w.length];
        for (int i=0; i < w.length; i++) {
            int weight = w[i];
            int max = 0;
            if (weight <= W) {
                max = weight;
            }
            for (int k=i-1; k>=0; k--) {
                if (matrix[k] <= W && matrix[k] > max) {
                    max = matrix[k];
                }
                int sum = matrix[k] + weight;
                if ((sum <= W) && sum > max) {
                    max = sum;
                }
                sum = w[k] + weight;
                if ((sum <= W) && sum > max) {
                    max = sum;
                }
            }
            matrix[i] = max;
        }
        
        //System.out.println(Arrays.toString(matrix));

        return matrix[w.length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

