package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * 경주로 건설
 */
public class level3_32 {

    private int[][] move = new int[][]{{0, 1}, {0, -1},{1, 0}, {-1, 0}};

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int length = board.length;
        int[][][] visited = new int[4][length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                visited[0][i][j] = 10000000;
                visited[1][i][j] = 10000000;
                visited[2][i][j] = 10000000;
                visited[3][i][j] = 10000000;
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, findMinCost(i, board, answer, length, visited));
        }

        return answer;
    }

    private int findMinCost(int startDirection, int[][] board, int answer, int length, int[][][] visited) {
        PriorityQueue<Road> queue = new PriorityQueue<Road>();

        queue.add(new Road(0, 0, 0, startDirection));
        visited[startDirection][0][0] = 0;

        while (!queue.isEmpty()) {

            Road current = queue.poll();
            int x = current.x;
            int y = current.y;
            int cost = current.cost;
            int direction = current.direction;

            if (x == length - 1 && y == length - 1) {
                answer = Math.min(answer, cost);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];


                if (!validRoad(board, length, nx, ny)) {
                    continue;
                }


                int nextCost = addCost(cost, i, direction);
                if (visited[direction][nx][ny] < nextCost) {
                    continue;
                }
                visited[direction][nx][ny] = nextCost;

                queue.add(new Road(nx, ny, nextCost, i));

            }
        }
        return answer;
    }

    private int addCost(int cost, int i, int direction) {
         if (i == direction) {
            cost += 100;
        } else {
            cost += 600;
        }

        return cost;
    }

    private boolean validRoad(int[][] board, int length, int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= length || ny >= length || board[nx][ny] == 1) {
            return false;
        }

        return true;
    }

    private class Road implements Comparable<Road> {
        int x, y, cost, direction;

        public Road(int x, int y, int cost, int direction) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}), 900);
        Assertions.assertEquals(solution(new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}), 3800);
        Assertions.assertEquals(solution(new int[][]{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}), 2100);
        Assertions.assertEquals(solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}), 3200);
    }
}
