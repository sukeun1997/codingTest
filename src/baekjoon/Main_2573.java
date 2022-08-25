package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 빙산
 */
public class Main_2573 {

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");


        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        int map[][] = new int[n][m];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int ans = 0;

        while ((cnt = findCount(map)) < 2) {
            if (cnt == 0) {
                System.out.println(0);
                return;
            }
            ans++;
            Melt(map);
        }

        System.out.println(ans);

    }

    private static int move[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static void Melt(int[][] map) {

        Queue<Ice> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    queue.add(new Ice(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Ice ice = queue.poll();

            int x = ice.x;
            int y = ice.y;
            int meltCount = 0;

            for (int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != 0 || visited[nx][ny]) {
                    continue;
                }
                meltCount++;
            }


            if (map[x][y] - meltCount < 0) {
                map[x][y] = 0;
            } else {
                map[x][y] -= meltCount;
            }
        }
    }

    private static int findCount(int[][] map) {
        boolean[][] visited = new boolean[n][m];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(map, i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void dfs(int[][] map, int i, int j, boolean[][] visited) {

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nx = i + move[k][0];
            int ny = j + move[k][1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }

            dfs(map, nx, ny, visited);
        }
    }


    private static class Ice {
        int x, y;

        public Ice(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
