package baekjoon;

import java.util.Scanner;

public class Main_2133 {

    static int DP[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        DP = new int[31];
        DP[2] = 3;
        System.out.println(Tile(N));

    }

    private static int Tile(int n) {

        if (n % 2 == 1) {
            return 0;
        }

        for (int i = 4; i <=n ; i+= 2) {
            DP[i] += DP[i - 2] * 3;
            for (int j = 2; j <= i-4; j+= 2) {
                DP[i] += 2 * DP[j];
            }
            DP[i] += 2;
        }
        return DP[n];
    }
}
