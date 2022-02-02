package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 네트워크
 */
public class level2_23 {

    static int network = 0;
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;


        Set<Integer> list[] = new Set[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(list, i);
            }
        }
        return network;
    }

    private void bfs(Set<Integer>[] list, int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            Integer now = queue.poll();

            for (Integer next : list[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        network++;
    }

    @Test
    void test() {
//        Assertions.assertEquals(solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}}),2);
//        Assertions.assertEquals(solution(4,new int[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}}),4);
//        Assertions.assertEquals(solution(3,new int[][]{{1,1,0},{1,1,1},{0,1,1}}),1);

//        Assertions.assertEquals(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), 2);
//        Assertions.assertEquals(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}), 1);
        Assertions.assertEquals(solution(3, new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 1}}), 2);
//        Assertions.assertEquals(solution(4, new int[][]{{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}}), 1);
    }
}
