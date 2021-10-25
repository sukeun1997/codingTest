package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {

    static int DP[];
    static int list[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        DP = new int[100001];
        list = new int[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Continue(N));

    }

    private static int Continue(int n) {

        DP[1] = list[1];
        int maxindex = 1;
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                DP[i] = Math.max(DP[i - 1] + list[i], list[i]);
                if (DP[maxindex] < DP[i]) {
                    maxindex = i;
                }
            }
        }

        return DP[maxindex];
    }
}
