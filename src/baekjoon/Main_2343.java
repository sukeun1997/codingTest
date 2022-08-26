package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int l = max;
        int r = sum;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (condition(mid, m, arr)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }

    private static boolean condition(int mid, int m, int[] arr) {

        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                count++;
                sum = 0;
            }
            sum = sum + arr[i];
        }

        if (sum != 0) {
            count++;
        }

        return count <= m;
    }
}
