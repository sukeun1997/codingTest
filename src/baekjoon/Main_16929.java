package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16929 {

    static String[][] map;
    static int move[][] = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean visited[][];

    static int n , m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] s = br.readLine().split(" ");

         n = Integer.parseInt(s[0]);
         m = Integer.parseInt(s[1]);


        map = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = split[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(-1,-1,i, j, map[i][j]);
                }
            }
        }
        System.out.println("No");

    }

    private static void dfs(int bx, int by,int x, int y, String find) {


        for (int i = 0; i < 4; i++) {

            int nx = x + move[i][0];
            int ny = y + move[i][1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            if (nx == bx && ny == by) {
                continue;
            }

            if (visited[nx][ny] && map[nx][ny].equals(find)) {
                System.out.println("Yes");
                System.exit(0);
            }

            if (!visited[nx][ny] && map[nx][ny].equals(find)) {


                visited[nx][ny] = true;
                dfs(x, y, nx, ny, find);
            }



        }

    }
}
