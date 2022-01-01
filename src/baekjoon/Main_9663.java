package baekjoon;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_9663 {

    static int n;
    static int col[];
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        col = new int[n];

        dfs(0);

    }

    private static void dfs(int depth) {
        if (depth == n) {
         ans++;
         return;
        } 

            for (int i = 0; i < n ; i++) {
                col[depth] = i;

                if (Possibility(depth)) {
                    dfs(depth + 1);
                }

            }
        }

    private static boolean Possibility(int depth) {

        for (int i = 0; i < depth; i++) {

            if (col[depth] == col[i]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(col[depth] - col[i])) {
                return false;
            }
        }
        return true;
    }
}

