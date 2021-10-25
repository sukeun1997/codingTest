package baekjoon;

import java.util.Scanner;

public class Main_1699 {

    static int DP[];

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        DP = new int[100001];

        for (int i = 1; i*i <= N; i++) {
            DP[i*i] = 1;
        }
        System.out.println(Pow(N));
    }

    static int Pow(int n) {
        int count = 1;

        for (int i = 2; i <= n; i++) {
            if(DP[i] != 0) {
                count ++;
                continue;
            }
            DP[i] = DP[count * count] + DP[i - (count * count)];
            for (int co = count-1; co >= 1; co--) {
                DP[i] = Math.min(DP[i], DP[co * co] + DP[i - (co * co)]);
            }

        }
        return DP[n];
    }
}
