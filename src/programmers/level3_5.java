package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 섬 연결하기
 * 크루스칼
 */
public class level3_5 {

    static int parent [];

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    static void union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs,(o1, o2) -> o1[2]-o2[2]);


        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {

            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];

            int a = find(start);
            int b = find(end);

            if (a == b) {
                continue;
            }

            union(a, b);
            answer += cost;
        }
        return answer;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(4,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}),4);
        Assertions.assertEquals(solution(5,new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}),15);
        Assertions.assertEquals(solution(5,new int[][]{{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}}),8);
    }
}
