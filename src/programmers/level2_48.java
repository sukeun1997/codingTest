package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 전력망을 둘로 나누기
 */
public class level2_48 {

    public int solution(int n, int[][] wires) {

        ArrayList<Integer>[] tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            tree[a].add(b);
            tree[b].add(a);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            min = Math.min(min, find(wires[i], tree, n));
        }


        return min;
    }

    private int find(int[] wire, ArrayList<Integer>[] tree, int n) {
        int fir = wire[0];
        int sec = wire[1];

        tree[fir].remove(tree[fir].indexOf(sec));
        tree[sec].remove(tree[sec].indexOf(fir));

        int fTreeCount = findTree(tree, fir, n);
        int fSecCount = findTree(tree, sec, n);

        tree[fir].add(sec);
        tree[sec].add(fir);
        return Math.abs(fTreeCount - fSecCount);
    }

    private int findTree(ArrayList<Integer>[] trees, int fir, int n) {

        boolean visited[] = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(fir);

        int count = 0;
        visited[fir] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            visited[poll] = true;

            for (Integer next : trees[poll]) {
                if (!visited[next]) {
                    queue.add(next);
                }
            }
        }

        return count;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}), 3);
    }
}
