package baekjoon;

import java.util.Scanner;

public class Main_1300 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int l = 1;
        int r = k;

        while (l < r) {
            int mid = (l + r) / 2;

            if (condition(n, mid , k)) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }

        System.out.println(l);
    }

    private static boolean condition(int n, int mid, int k) {

        long count = 0;

        for (int i = 1; i <= n; i++) {
            count += Math.min(mid / i, n);
        }

        return count >= k;
    }
}
