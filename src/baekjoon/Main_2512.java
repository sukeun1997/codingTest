package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2512 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        int max = arr[arr.length - 1];

        if (sum <= m) {
            System.out.println(max);
            return;
        } else {

            int l = 1;
            int r = max + 1;

            while (l < r) {
                int mid = (l + r) / 2;

                if (condition(mid, m, arr)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }


            System.out.println(l - 1);
        }
    }

    private static boolean condition(int mid, int m, int[] arr) {

        int sum = 0;

        for (int i : arr) {
            if (i > mid) {
                sum += mid;
            } else {
                sum += i;
            }
        }
        return sum > m;
    }
}
