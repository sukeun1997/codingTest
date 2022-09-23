package programmers.level2;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 피로도 다시풀기
 */
public class level2_35 {

    boolean visited[];
    int count;

    public int solution(int k, int[][] dungeons) {
        count = 0;

        visited = new boolean[dungeons.length];

        Arrays.sort(dungeons, (o1, o2) -> o2[0] - o1[0]);

        dfs(0,  k, dungeons);

        return count;
    }

    private void dfs(int idx, int k, int[][] dungeons) {

        int length = dungeons.length;

        for (int i = 0; i < length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(idx + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }

        count = Math.max(count, idx);
    }


    @Test
    void test() {
        assertEquals(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}), 3);
        assertEquals(solution(40, new int[][]{{40, 20}, {10, 10}, {10, 10}, {10, 10}, {10, 10}}), 4);
    }
}
