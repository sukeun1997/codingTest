package programmers.level2;

import java.util.PriorityQueue;

/**
 * 게임 맵 최단거리
 */
public class level2_54 {

    private boolean[][] visited;
    private int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];

        answer = findMinDistance(n, m, maps);


        return answer;
    }

    private int findMinDistance(int n, int m, int[][] maps) {

        visited[0][0] = true;
        PriorityQueue<Location> queue = new PriorityQueue<>();
        queue.add(new Location(0, 0, 1));

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            int x = location.x;
            int y = location.y;
            int count = location.count;

            if (x == n - 1 && y == m - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];


                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }

                if (maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Location(nx, ny, count + 1));
                }
            }
        }


        return -1;
    }

    private class Location implements Comparable<Location> {
        int x, y, count;


        public Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Location o) {
            return this.count - o.count;
        }
    }
}
