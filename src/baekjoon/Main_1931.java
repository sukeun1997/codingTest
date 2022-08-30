package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1931 {

    /*public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {

            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);


        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                queue.add(arr[i]);
            } else {
                if (queue.peek()[1] <= arr[i][0]) {
                    queue.add(arr[i]);
                } else {
                    if (queue.peek()[1] > arr[i][1]) {
                        queue.poll();
                        queue.add(arr[i]);
                    }
                }
            }
        }

        System.out.println(queue.size());

    }*/

    /**
     * 다른 풀이
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {

            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int max = 0;
        int start = 0;
        int end = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= end) {
                max++;
                end = arr[i][1];
            } else {
                if (arr[i][1] < end) {
                    end = arr[i][1];
                }
            }
        }


        System.out.println(max);

    }
}
