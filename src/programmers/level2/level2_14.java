package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level2_14 {


    private class Node {
        int x, y,count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);

        return answer;

    }

    private int bfs(int[][] maps) {

        boolean visit[][];
        int rx[] = {1, -1, 0, 0};
        int ry[] = {0, 0, 1, -1};

        int n = maps.length;
        int m = maps[0].length;

        visit = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0,1));
        visit[0][0] = true;

        while (!queue.isEmpty()) {

            Node remove = queue.remove();
            int x = remove.x;
            int y = remove.y;
            int count = remove.count;
            for (int i = 0; i < 4; i++) {
                int nextx = x - rx[i];
                int nexty = y - ry[i];

                if (nextx == n-1 && nexty == m-1) {
                    return count+1;
                }


                if ((nextx >= 0 && nextx < n) && (nexty >= 0 && nexty < m)) {
                    if (!visit[nextx][nexty] && maps[nextx][nexty] == 1) {
                        queue.add(new Node(nextx, nexty,count+1));
                        visit[nextx][nexty] = true;
                    }
                }
            }
        }

        return -1;


    }


    @Test
    public void test() {
        assertEquals(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}), 11);
        assertEquals(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}), -1);
    }


}
