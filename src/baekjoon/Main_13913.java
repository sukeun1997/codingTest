package baekjoon;

import java.util.*;

public class Main_13913 {
    public static final int Max = 200000;
    static int n;
    static int m;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean visit[];
    static int dist[];
    static int[] from;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visit = new boolean[Max];
        dist = new int[Max];
        from = new int[Max];
        queue.add(n);
        visit[n] = true;


        while (!queue.isEmpty()) {
            int now = queue.remove();

            if (now - 1 >= 0) {
                if (!visit[now - 1]) {
                    visit[now - 1] = true;
                    queue.add(now - 1);
                    dist[now - 1] = dist[now] + 1;
                    from[now - 1] = now;
                }
            }
            if (now + 1 < Max) {
                if (!visit[now + 1]) {
                    visit[now + 1] = true;
                    queue.add(now + 1);
                    dist[now + 1] = dist[now] + 1;
                    from[now + 1] = now;
                }
            }
            if (now * 2 < Max) {
                if (!visit[now * 2]) {
                    visit[now * 2] = true;
                    queue.add(now * 2);
                    dist[now * 2] = dist[now] + 1;
                    from[now * 2] = now;
                }
            }
        }

        System.out.println(dist[m]);

        Stack<Integer> s = new Stack<>();
        s.add(m);
        for (int i = dist[m]; i > 0; i--) {
            s.add(from[m]);
            m = from[m];
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }



    }
}
