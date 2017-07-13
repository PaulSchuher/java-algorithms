import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int notesCount = 0;

        if (m >= 10) {
            notesCount += Math.floor(m / 10);
            m = m % 10;
        }

        if (m >= 5) {
            notesCount += Math.floor(m / 5);
            m = m % 5;
        }

        notesCount += m;

        return notesCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

