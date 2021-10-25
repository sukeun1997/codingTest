package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_3085 {

    static String list[][];
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());
        list = new String[N][N];
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    list[i][j] = s[j];
                }
            }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N-1; i++) {
            for (int j = 0; j <= N-1 ; j++) {

                //오른쪽 swap
                if(j < N-1) {
                    swapNext(i, j);
                    if (checkMax(i, j) > max) {
                        max = checkMax(i, j);
                    }
                    swapNext(i, j);
                }

                // 아래쪽 스왑
                if(i < N-1) {
                    swapDown(i, j);
                    if (checkMax(i, j) > max) {
                        max = checkMax(i, j);
                    }
                    swapDown(i, j);
                }
            }
        }
        System.out.println(max);

    }

    private static void swapDown(int i, int j) {
        String temp = list[i][j];
        list[i][j] = list[i+1][j];
        list[i+1][j] = temp;
    }

    private static void swapNext(int i, int j) {
        String temp = list[i][j];
        list[i][j] = list[i][j + 1];
        list[i][j + 1] = temp;
    }

    private static int checkMax(int i,int j) {
        int row = 0, col = 0;
        for (int k = 0; k < N ; k++) {
            if (list[i][k].equals(list[i][j])) {
                row += 1;
            }
        }

        for (int k = 0; k < N ; k++) {
            if (list[k][j].equals(list[i][j])) {
                col += 1;
            }
        }
        return Math.max(row, col);
    }
}
