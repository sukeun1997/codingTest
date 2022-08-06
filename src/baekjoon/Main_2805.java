package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] tree = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;
        while (st.hasMoreTokens()) {
            tree[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);


        long l = 0;
        long r = tree[tree.length - 1] + 1;

        while (l < r) {

            long mid = (l + r) / 2;

            if (isSatisfiedBy(tree, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l - 1);
    }

    private static boolean isSatisfiedBy(int[] tree, int m, long mid) {

        long cur = 0;

        for (int i : tree) {

            if (i - mid > 0) {
                cur += i - mid;
            }
        }

        return cur < m;
    }
}
