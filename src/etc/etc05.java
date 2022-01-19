package etc;

import java.util.Scanner;

/**
 * 시각 (구현)
 */
public class etc05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 59; j++) {
                for (int k = 0; k <= 59; k++) {
                    String s = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if (s.contains("3")) {
                        count++;
                    }

                }
            }
        }
        System.out.println(count);

    }
}
