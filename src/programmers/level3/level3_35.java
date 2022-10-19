package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class level3_35 {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];

        ArrayList<int[]> answers = new ArrayList<>();

        ArrayList<Course> courses[] = new ArrayList[n + 1];

        int[] courseCost = getInitCourseCost(n);

        init(n, paths, courses);

        Set<Integer> starts = getInitStart(gates);

        Queue<Course> queue = new LinkedList<>();

        for (int gate : gates) {
            queue.add(new Course(gate, 0));
        }

        while (!queue.isEmpty()) {

            Course course = queue.poll();
            int to = course.to;
            int cost = course.cost;

            if (Arrays.stream(summits).anyMatch(value -> value == to)) {
                answers.add(new int[]{to, cost});
                continue;
            }


            for (Course next : courses[to]) {

                if (!starts.contains(next.to)) {
                    int intensity = Math.max(cost, next.cost);

                    if (courseCost[next.to] > intensity) {
                        courseCost[next.to] = intensity;
                        queue.add(new Course(next.to, intensity));
                    }
                }
            }
        }

        Collections.sort(answers, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        return answers.get(0);
    }

    private Set<Integer> getInitStart(int[] gates) {
        Set<Integer> starts = new HashSet<>();

        for (int gate : gates) {
            starts.add(gate);
        }
        return starts;
    }

    private int[] getInitCourseCost(int n) {
        int[] courseCost = new int[n + 1];
        Arrays.fill(courseCost, Integer.MAX_VALUE);
        return courseCost;
    }

    private void init(int n, int[][] paths, ArrayList<Course>[] courses) {
        for (int i = 1; i <= n; i++) {
            courses[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int start = path[0];
            int to = path[1];
            int cost = path[2];

            courses[start].add(new Course(to, cost));
            courses[to].add(new Course(start, cost));
        }
    }

    private class Course {
        int to, cost;

        public Course(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[]{1, 3}, new int[]{5}), new int[]{5, 3});
        Assertions.assertArrayEquals(solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[]{2, 3, 4}), new int[]{3, 4});
        Assertions.assertArrayEquals(solution(7, new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[]{3, 7}, new int[]{1, 5}), new int[]{5, 1});
    }
}
