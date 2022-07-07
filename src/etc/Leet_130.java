package etc;

import org.junit.jupiter.api.Test;

public class Leet_130 {

    public void solve(char[][] board) {
        int xLen = board.length;
        int yLen = board[0].length;

        for (int i = 0; i < xLen; i++) {
            if (board[i][yLen - 1] == 'O') {
                changeBoard(i, yLen - 1, board);
            }

            if (board[i][0] == 'O') {
                changeBoard(i, 0, board);
            }
        }

        for (int i = 1; i < yLen - 1; i++) {

            if (board[0][i] == 'O') {
                changeBoard(0, i, board);
            }
            if (board[xLen - 1][i] == 'O') {
                changeBoard(xLen - 1, i, board);
            }
        }

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

        System.out.println();
    }

    int move[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void changeBoard(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }

        board[x][y] = '#';

        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            changeBoard(nx, ny, board);
        }
    }


    @Test
    void tset() {
        solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
