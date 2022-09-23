package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 컬러링북
 */
public class level2_50 {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(visited, picture, i, j, picture[i][j]));
                }
            }
        }


        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int dfs(boolean[][] visited, int[][] picture, int i, int j, int pic) {

        int count = 1;

        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] || pic != picture[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        count += dfs(visited, picture, i + 1, j, pic);
        count += dfs(visited, picture, i - 1, j, pic);
        count += dfs(visited, picture, i, j + 1, pic);
        count += dfs(visited, picture, i, j - 1, pic);


        return count;
    }


    @Test
    void test() {
        Assertions.assertArrayEquals(solution(6,4,new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}}),
                new int[]{4,5});
    }

}
