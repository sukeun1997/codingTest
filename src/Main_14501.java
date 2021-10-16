import java.util.Scanner;

public class Main_14501 {

    static int n;
    static int[][] list;
    static int result;
    static boolean visit[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        list = new int[n + 1][2];
        result = Integer.MIN_VALUE;
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
        }

        go(0, 0);
        System.out.println(result);
    }

    private static void go(int i, int sum) {
        if (i == n+1) {
            if (result < sum) {
                result = sum;
            }
            return;
        }

        for (int j = i; j <= n; j++) {
            if (!visit[j]) {
                visit[j] = true;
                if (i + list[j][0] <= n+1 && n-j+1 >= list[j][0]) {
                        go(j + list[j][0], sum + list[j][1]);
                } else {
                    go(n+1, sum);
                }
                visit[j] = false;
            }
        }
    }
}
