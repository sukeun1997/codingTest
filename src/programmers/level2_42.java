package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 거리두기 확인하기
 */
public class level2_42 {


    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < places.length; i++) {
            String[] p = places[i];

            for (int j = 0; j < 5; j++) {
                if (arrayList.size() != i) {
                    break;
                }
                for (int k = 0; k < 5; k++) {

                    if (p[j].charAt(k) == 'P') {
                        if (!bfs(j, k, p)) {
                            arrayList.add(0);
                            break;
                        }
                    }
                }
            }

            if (arrayList.size() == i) {
                arrayList.add(1);
            }


        }

        return arrayList.stream().mapToInt(value -> value).toArray();
    }

    private boolean bfs(int j, int k, String[] p) {
        int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(j, k));

        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || (nx == j && ny == k)) {
                    continue;
                }

                int d = Math.abs(j - nx) + Math.abs(k - ny);

                if (p[nx].charAt(ny) == 'P' && d <= 2) {
                    return false;
                } else if (p[nx].charAt(ny) == 'O' && d < 2) {
                    queue.add(new Node(nx, ny));
                }
            }
        }

        return true;
    }


    @Test
    void test() {
        assertArrayEquals(
                solution(
                        new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}),
                new int[]{1, 0, 1, 1, 1});
    }
}
