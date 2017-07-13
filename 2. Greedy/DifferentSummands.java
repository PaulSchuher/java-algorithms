import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int sum = 0;
        while (sum < n) {
            int potentialSummand = (summands.size() > 0) ? summands.get(summands.size() - 1) + 1 : 1;
            if (n - sum > potentialSummand * 2) {
                summands.add(potentialSummand);
                sum += potentialSummand;
            } else {
                summands.add(n - sum);
                sum = n;
            }
        }

        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

