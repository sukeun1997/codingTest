import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697 {

    public static final int Max = 200001;
    // 0 <= N <= 100000 , 0 <= k <= 100000
    // x-1 or x+1 , 2*x
    static int min_time[];
    static boolean visit[];
    static Queue<Integer> queue = new LinkedList<>();
    static int n;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visit = new boolean[Max];
        min_time = new int[Max];
        queue.add(n);
        min_time[n] = 0;
        visit[n] = true;
        go();
        System.out.println(min_time[k]);
    }

    private static void go() {
        while (!queue.isEmpty()) {

            int now = queue.remove();
            if (now - 1 >= 0) {
                if (!visit[now - 1]) {
                    queue.add(now - 1);
                    visit[now - 1] = true;
                    min_time[now - 1] = min_time[now] + 1;
                }
            }
            if (now + 1 < Max) {
                if (!visit[now + 1]) {
                    queue.add(now + 1);
                    visit[now + 1] = true;
                    min_time[now + 1] = min_time[now] + 1;
                }
            }
            if (now * 2 < Max) {
                if (!visit[now * 2]) {
                    queue.add(now * 2);
                    visit[now * 2] = true;
                    min_time[now * 2] = min_time[now] + 1;
                }
            }
        }

    }
}
