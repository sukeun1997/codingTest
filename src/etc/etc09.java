package etc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 떡볶이 떡 만들기 (이진탐색)
 *
 */
public class etc09 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int list[] = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        // 10 15 17 19
        System.out.println(binarySearch(list, m, 0, list[n-1]));

    }

    private static int binarySearch(int[] list, int find, int start, int end) {

        int result = 0;
        while (start <= end) {
            int total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < list.length; i++) {
                if (list[i] > mid) {
                    total += list[i] - mid;
                }
            }

            if (total < find) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
}
