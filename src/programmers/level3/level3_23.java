package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 사라지는 발판
 */
public class level3_23 {

    int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(int[][] board, int[] aloc, int[] bloc) {

        int answer = 0;


        answer = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], 0).count;

        return answer;
    }

    private Result dfs(int[][] board, int x1, int y1, int x2, int y2, int count) {


        boolean isWin = false;
        int minCount = 25;
        int maxCount = count;
        if (board[x1][y1] == 1) {
            for (int i = 0; i < move.length; i++) {
                int nx = x1 + move[i][0];
                int ny = y1 + move[i][1];

                if (!isValid(board, nx, ny)) {
                    continue;
                }

                board[x1][y1] = 0;
                Result d = dfs(board, x2, y2, nx, ny, count + 1);
                isWin |= !d.win;
                if (!d.win) {
                    minCount = Math.min(minCount, d.count);
                } else {
                    maxCount = Math.max(maxCount, d.count);
                }

                board[x1][y1] = 1;
            }
        }

        return new Result(isWin, isWin ? minCount : maxCount);
    }

    private boolean isValid(int[][] board, int nx, int ny) {
        if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] == 0) {
            return false;
        }
        return true;
    }


    private class Result {
        boolean win;
        int count;

        public Result(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 0}, new int[]{1, 2}), 5);
    }
}
