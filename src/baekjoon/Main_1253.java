package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좋다
 */
public class Main_1253 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int l = 0;
            int r = arr.length - 1;

            while (l < r) {

                long sum = arr[l] + arr[r];

                if (l == i) {
                    l++;
                    continue;
                } else if (r == i) {
                    r--;
                    continue;
                }

                if (arr[i] > sum) {
                    l++;
                } else if (arr[i] < sum) {
                    r--;
                } else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
