package baekjoon;

import java.util.*;

public class Main_2667 {

    static boolean visited[][];
    static Queue<Integer> queue = new LinkedList<>();
    static int graph[];
    static int n;
    static int graphCount = 0;
    static int pair[][];
    static int rx[] = {1, -1, 0, 0};
    static int ry[] = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        sc.nextLine();
        pair = new int[n][n];
        graph = new int[10000];
        visited = new boolean[n+1][n+1];

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                pair[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pair[i][j] > 0 && !visited[i][j]) {
                    bfs(i,j,pair[i][j]);
                    graphCount++;
                }
            }
        }

        System.out.println(graphCount);
        Arrays.stream(graph).filter(value -> value!=0).sorted().forEach(value -> System.out.println(value));
    }

    private static void bfs(int x, int y,int findNum) {

        visited[x][y] = true;
        queue.add(x);
        queue.add(y);
        graph[graphCount] += 1;
        while (!queue.isEmpty()) {

            x = queue.remove();
            y = queue.remove();
            for (int j = 0; j < 4; j++) {
                int x1 = x - rx[j];
                int y1 = y - ry[j];
                if ((x1 >= 0 && x1 < n) && (y1 >= 0 && y1 < n)) {
                    if (!visited[x1][y1] && pair[x1][y1] == findNum) {
                        visited[x1][y1] = true;
                        graph[graphCount] += 1;
                        queue.add(x1);
                        queue.add(y1);
                    }
                }
            }
        }
    }
}


