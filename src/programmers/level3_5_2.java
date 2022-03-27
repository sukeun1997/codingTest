package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static programmers.level3_5.find;

/**
 * 섬 연결하기 프림
 */
public class level3_5_2 {


    static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static boolean visited[];
    static Queue<Node> queue = new PriorityQueue<>();
    static ArrayList<Node> arrayList[];

    public int solution(int n, int[][] costs) {
        int answer = 0;

        visited = new boolean[n];
        arrayList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            arrayList[start].add(new Node(end,cost));
            arrayList[end].add(new Node(start,cost));
        }

        queue.add(new Node(0,0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            int to = poll.to;
            if (visited[to]) {
                continue;
            }
            int cost = poll.cost;
            answer += cost;

            visited[to] = true;

            for (Node next : arrayList[to]) {
                if (!visited[next.to]) {
                    queue.add(new Node(next.to, next.cost));
                }
            }
        }

        return answer;
    }



    @Test
    void test() {
        Assertions.assertEquals(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}), 4);
        Assertions.assertEquals(solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}), 15);
        Assertions.assertEquals(solution(5, new int[][]{{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}}), 8);
    }
}

