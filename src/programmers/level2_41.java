package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 배달
 */
public class level2_41 {

    static class Node{
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

    }

    ArrayList<Node> [] arrayList;
    int[] minCost;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        arrayList = new ArrayList[N + 1];
        minCost = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        Arrays.fill(minCost, Integer.MAX_VALUE);

        for (int[] ints : road) {
            int start = ints[0];
            int end = ints[1];
            int cost = ints[2];

            arrayList[start].add(new Node(end, cost));
            arrayList[end].add(new Node(start, cost));
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(node -> node.cost));

        priorityQueue.add(new Node(1, 0));
        minCost[1] = 0;

        while (!priorityQueue.isEmpty()) {

            Node poll = priorityQueue.poll();

            int to = poll.to;
            int cost = poll.cost;

            if (minCost[to] < cost) {
                continue;
            }


            for (Node node : arrayList[to]) {
                int next = node.to;
                int nextCost = node.cost;
                if (minCost[next] > cost+nextCost) {
                    minCost[next] = cost + nextCost;
                    priorityQueue.add(new Node(next, minCost[next]));
                }
            }

        }

        for (int i : minCost) {
            if (i <= K) {
                answer++;
            }
        }
        return answer;
    }

    @Test
    void test() {

//        Assertions.assertEquals(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3),4);
        Assertions.assertEquals(solution(6,new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},4),4);
    }
}
