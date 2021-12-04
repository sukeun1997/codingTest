package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            int next = sc.nextInt();


            if (next == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append("0\n");
                }else {
                    sb.append(priorityQueue.poll() + "\n");
                }
            } else {
                priorityQueue.add(next);
            }


        }

        System.out.println(sb);
    }
}
