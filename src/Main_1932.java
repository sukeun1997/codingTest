import java.util.Arrays;
import java.util.Scanner;

public class Main_1932 {

    static int dp[][];
    static int list[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new int[502][502];
        list = new int[502][502];
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= i ; j++) {
                list[i][j] = sc.nextInt();
            }
        }
        System.out.println(Tringle(N));

    }

    private static int Tringle(int n) {

        for (int i = n; i >= 1 ; i--) {
            for (int j = 1; j <= n ; j++) {
                    dp[i][j] = list[i][j]+ Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return Arrays.stream(dp[1]).max().getAsInt();
    }

}
