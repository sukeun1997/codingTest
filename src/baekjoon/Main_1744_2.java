package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 수 묶기
 */
public class Main_1744_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();

        PriorityQueue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        PriorityQueue<Integer> zero = new PriorityQueue<>();
        PriorityQueue<Integer> one = new PriorityQueue<>();

        for (int j = 0; j < i; j++) {
            int n = sc.nextInt();

            if (n == 0) {
                zero.add(0);
            } else if (n == 1) {
                one.add(1);
            } else if (n > 1) {
                positive.add(n);
            } else {
                negative.add(n);
            }
        }

        long sum = 0;
        while (!positive.isEmpty()) {

            Integer a = positive.poll();

            if (positive.isEmpty()) {
                sum += a;
                break;
            }
            Integer b = positive.poll();

            sum += a * b;
        }

        while (!negative.isEmpty()) {
            Integer a = negative.poll();

            if (negative.isEmpty()) {
                if (!zero.isEmpty()) {
                    zero.poll();
                } else {
                    sum += a;
                }
                break;
            }
            Integer b = negative.poll();

            sum += a * b;
        }

        sum += one.size();

        System.out.println(sum);


    }
}
