package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int deadLine = Integer.parseInt(input[0]);
            int reward = Integer.parseInt(input[1]);
            list.add(new int[]{deadLine, reward});
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }

            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < list.size(); i++) {
            int[] work = list.get(i);

            queue.add(work[1]);

            if (work[0] < queue.size()) {
                queue.poll();
            }

        }


        System.out.println(queue.stream().mapToLong(value -> value).sum());
    }
}
