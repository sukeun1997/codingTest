package baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 카드 정렬하기
 */
public class Main_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        int sum = 0;


        while (!queue.isEmpty()) {
            Integer a = queue.poll();

            if (queue.isEmpty()) {
                break;
            }

            Integer b = queue.poll();

            sum += a + b;
            queue.add(a + b);
        }

        System.out.println(sum);


    }

}
