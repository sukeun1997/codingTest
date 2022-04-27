package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_16236 {

    static int n;
    static int map[][];
    static int move[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static Node node;
    static class Node implements Comparable<Node>{
        int x,y,time,eat,size;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public Node(int x, int y, int time, int eat, int size) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.eat = eat;
            this.size = size;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time == o.time) {
                return o.x - this.x;
            } else if (this.x == o.x) {
                return o.y - this.y;
            }
            return o.time - this.time;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);

                if (map[i][j] == 9) {
                    node = new Node(i, j, 0, 0, 2);
                    map[i][j] = 0;

                }
            }
        }


        while (find_eat()) {
            bfs();
        }
        System.out.println(node.time);

    }

    private static boolean find_eat() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < node.size && map[i][j] != 0) {
                    return  true;
                }
            }
        }
        return false;
    }

    private static void bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean visited[][] = new boolean[n][n];

        queue.add(new Node(node.x,node.y,0));
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            int x1 = poll.x;
            int y1 = poll.y;
            int time = poll.time;

            if (map[x1][y1] < node.size && map[x1][y1] != 0) {
                node.x = x1;
                node.y = y1;
                node.time += time;
                node.eat += 1;
                if (node.eat == node.size) {
                    node.size++;
                    node.eat = 0;
                }
                map[x1][y1] = 0;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x1 - move[i][0];
                int ny = y1 - move[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] <= node.size) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, time + 1));
                }
            }
        }
    }
}
