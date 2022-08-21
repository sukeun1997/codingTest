package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 부분합
 */
public class Main_1806 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = Integer.MAX_VALUE;

        int sum = 0;

        int l = 0;
        int r = 0;

        while (r < arr.length) {
            sum += arr[r++];

            while (sum - arr[l] >= k) {
                sum -= arr[l];
                l++;
            }

            if (sum >= k) {
                len = Math.min(len, r - l);
            }

        }

        if (sum < k) {
            System.out.println(0);
            return;
        }

        System.out.println(len);
    }
}
