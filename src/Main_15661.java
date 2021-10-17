import java.util.Arrays;
import java.util.Scanner;

public class Main_15661 {

    static boolean visit[];
    static int n;
    static int list[][];
    static int result1[];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        list = new int[n+1][n+1];
        visit = new boolean[n+1];
        result1 = new int[n/2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                list[i][j] = sc.nextInt();
            }
        }
        go(1);
        System.out.println(min);
    }

    private static void go(int i) {
        if (i == n ) {

            int suma = 0, sumb = 0;
            for (int j = 1; j < n; j++) {
                for (int k = j+1; k <= n; k++) {
                    if(visit[j] && visit[k]) {
                        suma += list[j][k] + list[k][j];
                    } else if (!visit[j] && !visit[k]) {
                        sumb += list[j][k] + list[k][j];
                    }
                }
            }
            int sum = Math.abs(suma - sumb);
            if (min > sum) {
                min = sum;
            }
            return;
        }

                visit[i] = true;
                go(i + 1);
                visit[i] = false;
                go(i + 1);

    }
}
