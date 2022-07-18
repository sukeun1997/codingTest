package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Course Schedule ( 위상 정렬 )
 */
public class Leet_207 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int s = prerequisite[0];
            int f = prerequisite[1];
            graph.get(f).add(s);
            inDegree[s] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            ArrayList<Integer> nodeList = graph.get(node);

            for (Integer next : nodeList) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    void test() {
        Assertions.assertTrue(canFinish(2, new int[][]{{1, 0}}));
        Assertions.assertFalse(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

}
