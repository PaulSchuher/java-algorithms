import java.util.*;

public class LargestNumber {
    private static String largestNumber(List<String> a) {
        String result = "";

        while(a.size() > 0) {
            String maxDigit = "0";
            int maxIndex = -1;
            for (int i = 0; i < a.size(); i++) {
                if (greaterOrEq(a.get(i), maxDigit)) {
                    maxDigit = a.get(i);
                    maxIndex = i;
                }
            }
            result += maxDigit;
            a.remove(maxIndex);
        }

        return result;
    }

    private static Boolean greaterOrEq(String digit, String maxDigit) {
        String newDigit = digit + maxDigit;
        maxDigit += digit;
        return Integer.valueOf(newDigit) >= Integer.valueOf(maxDigit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> a = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.next());
        }
        System.out.println(largestNumber(a));
    }
}

