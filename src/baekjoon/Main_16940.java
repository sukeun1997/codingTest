package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16940 {

    static Queue<Integer> queue[];
    static int n;
    static boolean visited[];
    static String result ;
    static String getResult ="";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n + 1];

        queue = new Queue[n+1];

        for (int i = 1; i <= n ; i++) {
            queue[i] = new LinkedList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            queue[n1].add(n2);
            queue[n2].add(n1);
        }

        sc.nextLine();

        result = sc.nextLine()+" ";

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        if (result.equals(getResult)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void bfs(int i) {

        getResult += i + " ";
        visited[i] = true;

        while (!queue[i].isEmpty()) {
            int next = queue[i].remove();

            if (!visited[next]) {
                visited[next] = true;
                getResult += next + " ";
            }
        }

    }
}
