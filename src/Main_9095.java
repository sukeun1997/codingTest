import java.util.Scanner;

public class Main_9095 {

    static int DP[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DP = new int[11];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(plus(N));
        }
    }

    public static int plus(int n) {
        if (n <= 3) {
            return DP[n];
        }
        if (DP[n] > 0) return DP[n];

        DP[n] = plus(n - 3) + plus(n - 2) + plus(n - 1);

        return DP[n];
    }
}
