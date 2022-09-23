package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 피로도
 */
public class level2_26 {

    static int max;

    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int length = dungeons.length;
        boolean visited[] = new boolean[length];
        max = 0;


            dfs( 0, dungeons, visited, k);

        return max;
    }

    private void dfs(int depth, int[][] dungeons, boolean[] visited, int k) {

        for (int j = 0; j < dungeons.length; j++) {
            if (!visited[j] && dungeons[j][0] <= k) {
                visited[j] = true;
                dfs( depth + 1, dungeons, visited, k- dungeons[j][1]);
                visited[j] = false;
            }
        }
        max = Math.max(max, depth);

    }


    @Test
    void test() {
        assertEquals(solution(80,new int[][]{{80,20},{50,40},{30,10}}), 3);
        assertEquals(solution(40,new int[][]{{40, 20}, {10, 10}, {10, 10}, {10, 10}, {10, 10}}), 4);
    }
}
