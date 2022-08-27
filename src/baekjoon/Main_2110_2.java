package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2110_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);

        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);


        int l = 1;
        int r = arr[arr.length - 1] + 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (condition(c, mid, arr)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }


        System.out.println(l - 1);
    }

    private static boolean condition(int c, int mid, int[] arr) {

        int count = 1;
        int now = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (now + mid <= arr[i]) {
                count++;
                now = arr[i];
            }
        }

        return count < c;
    }
}
