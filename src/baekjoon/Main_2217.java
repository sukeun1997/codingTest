package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_2217 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer endure[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            endure[i] = sc.nextInt();
        }

        Arrays.sort(endure, Collections.reverseOrder());

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, endure[i - 1] * i);
        }

        System.out.println(max);

    }
}
