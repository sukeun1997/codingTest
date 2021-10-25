package baekjoon;

import java.util.Scanner;

public class Main_15990 {

    /*
    핵심 : 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
    I = DP[i][j] + 1 , 2, 3 i : 숫자 , J : 마지막에 사용한 숫자
    DP[i][1] = DP[i-1][2] + DP[i-1][3]
    DP[i][2] = DP[i-2][1] + DP[i-2][3]
    DP[i][3] = DP[i-3][1] + DP[i-3][2]
     */
    static long DP[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        DP = new long[100001][4];
        DP[1][1] = 1;
        DP[2][2] = 1;
        DP[3][1] = 1;
        DP[3][2] = 1;
        DP[3][3] = 1;
        for (int i = 0; i < N; i++) {
            int T = sc.nextInt();
            System.out.println(Plus(T));
        }
    }

    static long Plus(int i) {

        if (DP[i][1] != 0 || DP[i][2] != 0 || DP[i][3] != 0) {
            return (DP[i][1] + DP[i][2] + DP[i][3]) % 1000000009;
        }

        for (int l = 4; l <= i; l++) {
            DP[l][1] = ((DP[l - 1][2] % 1000000009) + (DP[l - 1][3] % 1000000009) % 1000000009);
            DP[l][2] = ((DP[l - 2][1] % 1000000009) + (DP[l - 2][3] % 1000000009) % 1000000009);
            DP[l][3] = ((DP[l - 3][2] % 1000000009) + (DP[l - 3][1] % 1000000009) % 1000000009);
        }

        return (DP[i][1] + DP[i][2] + DP[i][3]) % 1000000009;
    }
}
