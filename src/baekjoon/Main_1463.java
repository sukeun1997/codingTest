package baekjoon;

import java.io.*;
import java.util.Scanner;


// DP[N] = Math.min(DP[N/3], DP[N/2] , DP[N-1])
public class Main_1463 {

    static int DP[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        DP = new int[X+1];
        bw.write(String.valueOf(go(X)));
        bw.flush();
    }

    public static int go(int a) {

        if (a == 1) {
            return 0;
        }
        if (DP[a] > 0) {
            return DP[a];
        }
        DP[a] = go(a-1)+1;
            if (a % 3 == 0) {
                int temp = go(a / 3) + 1;
                if(DP[a] > temp ) {
                    DP[a] = temp;
                }
            }
            if (a % 2 == 0) {
                int temp = go(a / 2) + 1;
                if(DP[a] > temp ) {
                    DP[a] = temp;
                }
            }
        return DP[a];
    }
}
