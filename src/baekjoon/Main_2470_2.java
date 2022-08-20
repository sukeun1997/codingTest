package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);


        int l = 0;
        int r = arr.length - 1;

        int max = Integer.MAX_VALUE;

        int[] ans = new int[2];
        while (l < r) {

            int abs = Math.abs(arr[l] + arr[r]);
            if (max > abs) {
                max = abs;
                ans[0] = arr[l];
                ans[1] = arr[r];
            }

            if (Math.abs(arr[l]) > Math.abs(arr[r])) {
                l++;
            } else {
                r--;
            }
        }


        System.out.println(ans[0] + " " + ans[1]);

    }
}
