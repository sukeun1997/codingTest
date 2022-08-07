package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        Arrays.sort(arr);

        int find[] = new int[m];

        for (int i = 0; i < m; i++) {
            find[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            System.out.println(binarySearch(arr,find[i]));
        }

    }

    private static int binarySearch(int[] arr, int find) {

        int l = 0 ;

        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == find) {
                return 1;
            } else if (arr[mid] > find) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
}
