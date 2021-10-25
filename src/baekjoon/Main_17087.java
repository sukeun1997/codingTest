package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_17087 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            long value = Math.abs(Long.parseLong(st.nextToken()) - S);
            a[i] = value;
        }
        long ans = a[0];
        for (int i = 1; i < N; i++) {
            ans = Gcd(ans, a[i]);
        }
        System.out.println(ans);

    }

    public static long Gcd(long x, long y) {
        if (y == 0) {
            return x;
        }

        long a,b;
        b = x % y;
        a = y;
        return Gcd(a, b);
    }
}
