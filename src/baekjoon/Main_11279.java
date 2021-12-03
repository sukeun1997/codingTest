package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();

            if (next == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueue.remove());
                }
            } else {
                priorityQueue.add(next);
            }
        }

    }
}
