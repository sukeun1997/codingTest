package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Number of Provinces
 */
public class Leet_547 {

   /* public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean visited[] = new boolean[length];

        ArrayList<Integer> arrayList[] = new ArrayList[length];

        for (int i = 0; i < length; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i == j) {
                    continue;
                }

                if (isConnected[i][j] == 1) {
                    arrayList[i].add(j);
                }
            }
        }

        int answer = 0 ;
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                answer++;
                find(i, visited, arrayList);
            }
        }

        return answer;


    }

    private void find(int now, boolean[] visited, ArrayList<Integer>[] arrayList) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);

        while (!queue.isEmpty()) {

            Integer cur = queue.poll();

            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;

            for (Integer next : arrayList[cur]) {
                if (!visited[next]) {
                    queue.add(next);
                }
            }
        }
    }*/

    /**
     * 더 빠른 풀이 dfs
     */

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean visited[] = new boolean[length];

        int answer = 0;

        for (int i = 0; i < isConnected.length; i++) {
                if (!visited[i]) {
                    dfs(isConnected,i, visited);
                    answer++;
                }
        }

        return answer;
    }

    private void dfs(int[][] isConnected,int j,boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (isConnected[j][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(isConnected, i, visited);
            }
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), 2);
        Assertions.assertEquals(findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}), 3);
    }
}
