package baekjoon;


import java.util.Scanner;

public class Main_16198 {

    static int n;
    static int max = 0;
    static int w[];
    static boolean visit[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        w = new int[n];
        visit = new boolean[n];


        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        dfs(0,0);
        System.out.println(max);

    }

    private static void dfs(int i, int result) {

        if (n - i == 2) {
            if (max < result) {
                max = result;
            }
            return;
        }

        for (int j = 1; j < n-1; j++) {

            if (!visit[j]) {
                visit[j] = true;

                int left = 0;
                int right = 0;

                for (int k = j; k >= 0; k--) {
                    if (!visit[k]) {
                        left = w[k];
                        break;
                    }
                }

                for (int k = j; k < n; k++) {
                    if (!visit[k]) {
                        right = w[k];
                        break;
                    }
                }
                dfs(i + 1, result + (left * right));
                visit[j] = false;
            }
        }
    }
}
