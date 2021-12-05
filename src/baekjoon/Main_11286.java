package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) ->
        {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 > o2 ? 1 : -1;
            } else {
                return Math.abs(o1) > Math.abs(o2) ? 1 : -1;
            }
        });

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            if (next != 0) {
                priorityQueue.add(next);
            } else {
                if (priorityQueue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(priorityQueue.poll() + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
