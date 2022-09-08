package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 네트워크
 */
public class level3_18 {

    /**
     *
     *  n = 1~200
     *  com = 0~n-1
     */
    private static int [] parent;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (i == j) {
                    continue;
                }

                if (computers[i][j] == 1 && !visited[j][i] && !visited[i][j]) {
                    visited[i][j] = true;
                    union(i, j);
                }
            }
        }

        boolean[] networks = new boolean[n];

        for (int i = 0; i < n; i++) {
            int getNetwork = find(parent[i]);
            if (!networks[getNetwork]) {
                answer++;
                networks[getNetwork] = true;
            }
        }

        return answer;
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    private static void union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}}),2);
        Assertions.assertEquals(solution(4,new int[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}}),4);
        Assertions.assertEquals(solution(3,new int[][]{{1,1,0},{1,1,1},{0,1,1}}),1);

        Assertions.assertEquals(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), 2);
        Assertions.assertEquals(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}), 1);
        Assertions.assertEquals(solution(3, new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 1}}), 2);
        Assertions.assertEquals(solution(4, new int[][]{{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}}), 1);
    }
}
