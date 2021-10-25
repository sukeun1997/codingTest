package baekjoon;

import java.util.Scanner;

public class Main_2981 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int N[] = new int[T];
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextInt();
            if (min < N[i]) {
                min = N[i];
            }
        }

        for (int i = 2; i <= min; i++) {
            int divid = min % i;
            for (int l = 0; l < T; l++) {
                if(divid != N[l] % i) {
                    break;
                }
                if (l == T - 1) {
                    System.out.print(i + " ");
                }
            }
        }

    }
}
