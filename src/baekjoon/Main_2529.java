package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2529 {

    static int n;
    static String[] strings;
    static boolean visit[];
    static int result[];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int mins[];
    static int maxs[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        strings = new String[n+1];
        for (int i = 1; i <= n; i++) {
            strings[i] = sc.next();
        }
        visit = new boolean[10];
        result = new int[n + 1];
        go(0);
        Arrays.stream(maxs).forEach(System.out::print);
        System.out.println();
        Arrays.stream(mins).forEach(System.out::print);
    }

    private static void go(int i) {

        if (i == n+1) {
            int sum = Arrays.stream(result).sum();
            if (sum >= max) {
                max = sum;
                maxs = result.clone();
            }
            if (sum < min) {
                min = sum;
                mins = result.clone();
            }
            return;
        }
        for (int j = 0; j < 10; j++) { //0~9 최대 9번 10^9
            if (!visit[j]) {
                if(i >= 1) {
                    if (strings[i].equals(">")) {
                        if (result[i - 1] > j) {
                            result[i] = j;
                        } else {
                            continue;
                        }
                    } else {
                        if (result[i - 1] < j) {
                            result[i] = j;
                        } else {
                            continue;
                        }
                    }
                } else {
                    result[i] = j;
                }
                visit[j] = true;
                go(i + 1);
                visit[j] = false;
            }
        }
    }
}
