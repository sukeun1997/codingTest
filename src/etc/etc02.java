package etc;

import java.util.Arrays;
import java.util.Scanner;

public class etc02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int card[][] = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                card[i][j] = sc.nextInt();
            }
            Arrays.sort(card[i]);
            max = Math.max(card[i][0], max);
        }

        System.out.println(max);
    }
}
