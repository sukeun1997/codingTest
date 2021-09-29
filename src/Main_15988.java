import java.io.*;

public class Main_15988 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long[] DP;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        DP = new long[10000001];

        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for (int i = 0; i < t; i++) {
            bw.write(Plus(Integer.parseInt(br.readLine()))+"\n");
        }
        bw.flush();
    }

    private static long Plus(int parseInt) {


        if (DP[parseInt] > 0) {
            return DP[parseInt] % 1000000009;
        }
        for (int i = 4; i <= parseInt; i++) {
            DP[i] = (DP[i-3]  % 1000000009) + (DP[i-2]% 1000000009) + (DP[i-1]% 1000000009);
        }

        return DP[parseInt] % 1000000009;
    }
}