package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 두 용액
 */
public class Main_2470 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.valueOf(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] ints = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        Arrays.sort(ints);


        int length = ints.length;
        int a = 0;
        int b = length - 1;

        int gap = Integer.MAX_VALUE;
        int lo = 0;
        int hi = 0;

        while (a < b) {
            int sum = ints[a] + ints[b];
            if (Math.abs(sum) < gap) {
                gap = Math.abs(sum);
                lo = ints[a];
                hi = ints[b];
            }

            if (sum > 0) {
                b--;
            } else {
                a++;
            }
        }


        System.out.println(lo + " " + hi);
    }
}
