package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_3085 {

    static String list[][];
    static boolean visited[][];
    static int N;
    static int rx[] = new int[]{-1, 1, 0, 0};
    static int ry[] = new int[]{0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new String[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                list[i][j] = s[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                findMax(i, j);
                start(i, j);
            }
        }

        System.out.println(max);
    }

    private static void start(int x, int y) {


        for (int i = 0; i < 4; i++) {
            int nx = x - rx[i];
            int ny = y - ry[i];

            if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
                if (!list[x][y].equals(list[nx][ny])) {
                    swap(x, y, nx, ny);
                    findMax(nx, ny);
                    swap(nx, ny, x, y);
                }
            }
        }
    }

    private static void findMax(int nx, int ny) {

        String cur = list[nx][ny];

        int count = 0;

        for (int i = nx; i >= 0; i--) {
            if (!list[i][ny].equals(cur)) {
                break;
            }
            count++;
        }

        for (int i = nx; i < N; i++) {
            if (!list[i][ny].equals(cur)) {
                break;
            }
            count++;
        }
        max = Math.max(max, count-1);

        count = 0;

        for (int i = ny; i >= 0; i--) {
            if (!list[nx][i].equals(cur)) {
                break;
            }
            count++;
        }

        for (int i = ny; i < N; i++) {
            if (!list[nx][i].equals(cur)) {
                break;
            }
            count++;
        }

        max = Math.max(max, count-1);

    }

    private static void swap(int x, int y, int nx, int ny) {
        String temp = list[x][y];
        list[x][y] = list[nx][ny];
        list[nx][ny] = temp;
    }
}
