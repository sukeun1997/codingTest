package baekjoon;

import java.util.Scanner;

public class Main_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int S = Math.min(A, B);
            int value = 0;
            for (int l = 1; l <= S; l++) {
                if ((A % l == 0) && (B % l == 0)) {
                    value = l;
                }
            }
            System.out.println(value*(A/value)*(B/value));
        }

    }
}
