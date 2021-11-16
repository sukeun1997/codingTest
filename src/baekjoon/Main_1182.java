package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1182 {


    static int n;
    static int s;
    static int numArray[];
    static boolean visit[];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        numArray = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            numArray[i] = sc.nextInt();
        }

        go(0,0, 0);

        System.out.println(count);
    }

    private static void go(int depth,int result, int start) {

        if (result == s && depth != 0) {
            count++;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                go(depth+1,result + numArray[i], i);
                visit[i] = false;
            }
        }

    }

}
