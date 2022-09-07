package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 게임 개발
 */
public class Main_1516 {

    /**
     * 2초 => 2억
     * N = 1~500 , 시간 1~100,000
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> list[] = new ArrayList[n + 1];
        int[] counts = new int[n + 1];
        int[] constructTime = new int[n + 1];
        int[] reqBuildTime = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            int time = sc.nextInt();
            constructTime[i] = time;

            int req = 0;
            while ((req = sc.nextInt()) != -1) {
                list[req].add(i);
                counts[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (counts[i] == 0) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer next : list[now]) {
                counts[next]--;
                reqBuildTime[next] = Math.max(reqBuildTime[next], constructTime[now] + reqBuildTime[now]);
                if (counts[next] == 0) {
                    queue.add(next);
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            System.out.println(constructTime[i] + reqBuildTime[i]);
        }

    }
}
