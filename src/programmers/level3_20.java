package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 등산코스 정하기
 */
public class level3_20 {

    /*
        n= 2~50000 , paths 1~200000 , w 1~10000000
        gate 는 2번 , summit 은 1번 꼭 방문 해야함
        gate 중복 방문 X , summit 도 1 곳만 방문
        쉬는시간 없이 가는 거리중 최대
        우선순위큐
     */

    /**
     * 1. 어떻게 gate 만 2번 꼭대기는 1번만 방문하게 할 것인가 ?
     * => 시작 gate count 만 2 , 꼭대기를 다 1 로 초기화 ?
     */
    private ArrayList<Trail> trails[];
    private HashSet<Integer> end;
    private HashSet<Integer> starts;
    private int[] dp;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {


        trails = new ArrayList[n + 1];
        end = new HashSet<>(summits.length);
        starts = new HashSet<>(gates.length);
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            trails[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < summits.length; i++) {
            end.add(summits[i]);
        }
        for (int i = 0; i < gates.length; i++) {
            starts.add(gates[i]);
        }

        for (int i = 0; i < paths.length; i++) {
            int start = paths[i][0];
            int to = paths[i][1];
            int cost = paths[i][2];

            trails[start].add(new Trail(to, cost));
            trails[to].add(new Trail(start, cost));
        }

        for (int i = 0; i < gates.length; i++) {
            findRoad(gates[i]);
        }


        int[] ans = new int[]{0, Integer.MAX_VALUE};
        Arrays.sort(summits);

        for (int summit : summits) {
                if (ans[1] > dp[summit]) {
                    ans[0] = summit;
                    ans[1] = dp[summit];
                }
        }
        return ans;
    }

    private void findRoad(int gate) {
        Queue<Trail> queue = new LinkedList<>();

        queue.add(new Trail(gate, 0));



        while (!queue.isEmpty()) {
            Trail trail = queue.poll();
            int to = trail.to;
            int cost = trail.cost;


            if (end.contains(to)) {
                continue;
            }

            for (Trail next : trails[to]) {
                if (!starts.contains(next.to)) {
                    int intensity = Math.max(next.cost, cost);

                    if (dp[next.to] > intensity) {
                        dp[next.to] = intensity;
                        queue.add(new Trail(next.to, intensity));
                    }
                }
            }
        }

    }

    private class Trail implements Comparable<Trail> {
        int to, cost;

        public Trail(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Trail o) {
            return this.cost - o.cost;
        }
    }


    @Test
    void test() {
        Assertions.assertArrayEquals(solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[]{1, 3}, new int[]{5}), new int[]{5, 3});
        Assertions.assertArrayEquals(solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[]{2, 3, 4}), new int[]{3, 4});
        Assertions.assertArrayEquals(solution(7, new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[]{3, 7}, new int[]{1, 5}), new int[]{5, 1});
    }
}
