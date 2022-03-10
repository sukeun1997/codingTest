package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 레이저
 */
public class Main_6087 {

    static String map[][];
    static int visited[][];
    static int move[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int min = Integer.MAX_VALUE;
    static Queue<Node> queue = new PriorityQueue<>();
    static int r, c;
    static class Node implements Comparable<Node>{
        int x,y,mirror,direction;

        public Node(int x, int y, int mirror, int direction) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.direction = direction;
        }

        @Override
        public int compareTo(Node o) {
            return mirror-o.mirror;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] s = br.readLine().split(" ");

         c = Integer.parseInt(s[0]);
         r = Integer.parseInt(s[1]);

        map = new String[r][c];
        visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line[] = br.readLine().split("");

            for (int j = 0; j < c; j++) {
                map[i][j] = line[j];
                if (map[i][j].equals("C") && queue.isEmpty()) {
                    queue.add(new Node(i, j, -1, -1));
                    visited[i][j] = 0;
                    map[i][j] = "S";
                }
            }
        }


        bfs();
    }

    private static void bfs() {

        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            int x = poll.x;

            int y = poll.y;
            int direction = poll.direction;
            int mirror = poll.mirror;

            if (map[x][y].equals("C") && visited[x][y] != 0) {
                System.out.println(mirror);
                return;
            }

            for (int i = 0; i < 4; i++) {
                    int nx = x - move[i][0];
                    int ny = y - move[i][1];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                        continue;
                    }

                    if ((visited[nx][ny] == 0 || visited[nx][ny] >= mirror) && (map[nx][ny].equals(".") || map[nx][ny].equals("C"))) {
                        visited[nx][ny] = mirror;
                        if (direction == i) {
                            queue.add(new Node(nx, ny, mirror, i));
                        } else {
                            queue.add(new Node(nx, ny, mirror + 1, i));
                        }
                    }

                }
            }
    }
}
