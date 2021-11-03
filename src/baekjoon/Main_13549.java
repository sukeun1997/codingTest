package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13549 {


    static Queue<Location> queue = new LinkedList<>();
    static int n, m;
    static boolean visited[];

    private static class Location {
        int current;
        int time;

        public Location(int current, int time) {
            this.current = current;
            this.time = time;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[200001];

        if (n == m) {
            System.out.println(0);
            return;
        }
        queue.add(new Location(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Location location = queue.remove();
            int next = location.current;
            int time = location.time;

            if (next == m) {
                System.out.println(time);
                return;
            }
            // 2*x
            if((2 * next) <= 100000) {
                if (!visited[2 * next]) {
                    visited[2 * next] = true;
                    queue.add(new Location(2 * next, time));
                }
            }
            // x-1
            if(next - 1 >= 0) {
                if (!visited[next - 1]) {
                    visited[next - 1] = true;
                    queue.add(new Location(next - 1, time + 1));
                }
            }
            // x+1

            if(next + 1 <= 100000) {
                if (!visited[next + 1]) {
                    visited[next + 1] = true;
                    queue.add(new Location(next + 1, time + 1));
                }
            }
        }
    }
}
