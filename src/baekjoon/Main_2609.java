package baekjoon;

import java.util.Scanner;

public class Main_2609 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int s = Math.min(N, M);
        int value = 0;
        for (int i = 1; i <= s; i++) {
            if ((N % i == 0) && (M % i == 0)) {
                value = i;
            }
        }
        System.out.println(value);
        System.out.println(value*(N/value)*(M/value));
    }
}
