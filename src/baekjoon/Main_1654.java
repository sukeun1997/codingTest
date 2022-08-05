package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);


        long[] lan = new long[n];

        for (int i = 0; i < n; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        long l = 1;
        long r = lan[lan.length-1] + 1;

        while (l < r) {

            long mid = l + (r - l) / 2;

            if (isSatisfiedBy(lan, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l - 1);

    }

    private static boolean isSatisfiedBy(long[] lan, int k, long mid) {

        long cur = 0;

        for (long i : lan) {
            cur += i / mid;
        }

        return cur < k;
    }
}
