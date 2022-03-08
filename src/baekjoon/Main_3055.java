package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;

/**
 * 탈출
 */
public class Main_3055 {

    static String map[][];
    static boolean visited[][];
    static boolean visited_water[][];
    static int min = 9999;
    static int r,c;
    static int move[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> water = new LinkedList<>();

    static class Node {

        private int x,y, count;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

         r = Integer.parseInt(s[0]);
         c = Integer.parseInt(s[1]);

        map = new String[r][c];
        visited = new boolean[r][c];
        visited_water = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s1[] = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = s1[j];
                if (map[i][j].equals("S")) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }

                if (map[i][j].equals("*")) {
                    water.add(new Node(i, j));
                    visited_water[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println(min == 9999 ? "KAKTUS" : min);

    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            waterChange();
            moveS();
        }
    }

    private static void moveS() {
        int size = queue.size();

        for (int i = 0; i < size; i++) {

            Node poll = queue.poll();

            int x = poll.x;
            int y = poll.y;
            int count = poll.count;

            if (map[x][y].equals("D")) {
                min = Math.min(min, count);
            }

            for (int j = 0; j < 4; j++) {
                int nx = x - move[j][0];
                int ny = y - move[j][1];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }

                if (!visited[nx][ny] && (map[nx][ny].equals(".") || map[nx][ny].equals("D"))) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, count+1));
                }
            }
        }
    }

    private static void waterChange() {

        int size = water.size();

        for (int i = 0; i < size; i++) {

            Node poll = water.poll();

            int x = poll.x;
            int y = poll.y;

            for (int j = 0; j < 4; j++) {
                int nx = x - move[j][0];
                int ny = y - move[j][1];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }

                if (!visited_water[nx][ny] && map[nx][ny].equals(".")) {
                    map[nx][ny] = "*";
                    visited_water[nx][ny] = true;
                    water.add(new Node(nx, ny));
                }
            }
        }
    }
}
