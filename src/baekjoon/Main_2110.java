package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long l = 1;
        long r = arr[arr.length - 1] - arr[0] + 1;

        while (l < r) {
            long mid = l + (r - l) / 2;

            if (isMaxDistance(arr, C, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l - 1);


    }

    private static boolean isMaxDistance(int[] arr, int c, long mid) {

        int cur = 1;
        long sum = arr[0] + mid;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= sum) {
                cur++;
                sum = arr[i] + mid;
            }
        }
        return cur < c;
    }
}
