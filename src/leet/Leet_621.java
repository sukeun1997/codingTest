package leet;

/**
 * Task Scheduler
 */
public class Leet_621 {

    public int leastInterval(char[] tasks, int n) {

        int c[] = new int[26];
        int max = 0;
        for (char task : tasks) {
            c[task - 'A']++;
            max = Math.max(c[task - 'A'], max);
        }

        int ans = (max - 1) * (n + 1);

        for (int i : c) {
            if (max == i) {
                ans++;
            }
        }

        return Math.max(ans, tasks.length);
    }
}
