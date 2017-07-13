import java.util.Scanner;
import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, double[] values, double[] weights) {
        double value = 0d;
        double currentWeight = 0d;
        List<Double> valueKoefs = new ArrayList<Double>();
        
        for (int i=0; i < values.length; ++i) {
            valueKoefs.add(i, (double)(values[i] / weights[i]));
        }

        while(currentWeight < capacity) {
            double remainingWeight = capacity - currentWeight;

            // Find the largest one
            double max = valueKoefs.get(0);
            int maxIndex = 0;
            for (int i=0; i < valueKoefs.size(); ++i) {
                if (valueKoefs.get(i) > max) {
                    max = valueKoefs.get(i);
                    maxIndex = i;
                }
            }
            if (valueKoefs.get(maxIndex) == -1d) {
                break;
            }
            valueKoefs.set(maxIndex, -1d);

            if (remainingWeight >= weights[maxIndex]) {
                currentWeight += weights[maxIndex];
                value += values[maxIndex];
            } else {
                value += values[maxIndex] * (remainingWeight / weights[maxIndex]);
                currentWeight = capacity;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        double[] values = new double[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = (double)scanner.nextInt();
            weights[i] = (double)scanner.nextInt();
        }
        System.out.print(String.format("%.4f%n", getOptimalValue(capacity, values, weights)));
    }
} 
