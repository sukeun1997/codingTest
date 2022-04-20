package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(arr);

        binarySearch(arr, m - 2, 0, arr[n - 1]);
    }

    private static int binarySearch(int[] arr, int m, int start, int end) {

        int result = 1;
        while (start <= end) {

            int mid = (start + end) / 2;
            m--;

            int now = Math.abs(arr[0] - arr[mid]);

            if (m == 0) {

                result = now;
            } if (arr[mid] > now) {

            }
        }

        return result;
    }
}
