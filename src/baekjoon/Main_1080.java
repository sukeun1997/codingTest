package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 행렬
 */
public class Main_1080 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int map[][] = new int[n][m];
        int fmap[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                fmap[i][j] = Integer.parseInt(split[j]);
            }
        }

        if (n < 3 || m < 3) {
            if (isSame(map, fmap)) {
                System.out.println(count);
            } else {
                System.out.println(-1);
            }
            return;
        }

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (map[i][j] != fmap[i][j]) {
                    changeMap(map, i, j);
                    count++;
                }
            }
        }

        if (isSame(map, fmap)) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }

    }

    private static boolean isSame(int[][] map, int[][] fmap) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != fmap[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void changeMap(int[][] map, int i, int j) {

        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (map[k][l] == 0) {
                    map[k][l] = 1;
                } else {
                    map[k][l] = 0;
                }
            }
        }
    }
}
