package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 프렌즈 4블록
 */
public class level2_58 {


    /**
     * 1. 전체에서 없어지는 블록 찾기
     * 2. 없어지는 블록 자리 매우기
     * 3. 다시 찾아서 없애기
     * 4. 없어지는 블록이 하나도 없을떄 까지 반복
     */
    String[][] boards;
    boolean[][] visited;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        int count = 0;

        boards = new String[m][n];

        for (int i = 0; i < m; i++) {
            String[] split = board[i].split("");
            for (int j = 0; j < n; j++) {
                boards[i][j] = split[j];
            }
        }


        while (true) {
            // 없어지는 블록 찾기
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!boards[i][j].equals("X")) {
                        dfs(i, j, m, n, boards[i][j]);
                    }
                }
            }

            count = blockRemove();

            if (count == 0) {
                break;
            }

            boardChange(m, n);
            answer += count;
        }

        return answer;
    }

    private void boardChange(int m, int n) {
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (!boards[i][j].equals("X") && boards[i + 1][j].equals("X")) {
                    moveBlock(i, j);
                }
            }
        }

    }

    private void moveBlock(int i, int j) {

        String temp = boards[i][j];
        boards[i][j] = "X";
        while (i < boards.length - 1 && boards[i + 1][j].equals("X")) {
            i++;
        }

        boards[i][j] = temp;
    }

    private int blockRemove() {
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]) {
                    count++;
                    boards[i][j] = "X";
                }
            }
        }

        return count;
    }

    private int[][] move = new int[][]{{0, 1}, {1, 0}, {1, 1}};

    private void dfs(int i, int j, int m, int n, String s) {


        for (int k = 0; k < 3; k++) {
            int nx = i + move[k][0];
            int ny = j + move[k][1];
            if (nx >= m || ny >= n || !boards[nx][ny].equals(s)) {
                return;
            }
        }

        visited[i][j] = true;
        visited[i][j + 1] = true;
        visited[i + 1][j] = true;
        visited[i + 1][j + 1] = true;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}), 14);
        Assertions.assertEquals(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}), 15);
    }
}
