package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_11003 {

    static class dNum {
        int seq;
        int value;

        public dNum(int seq, int value) {
            this.seq = seq;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<dNum> queue = new ArrayDeque<>();


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            while (!queue.isEmpty() && queue.peekLast().value > arr[i]) {
                queue.removeLast();
            }
            queue.add(new dNum(i, arr[i]));

            if (queue.peekFirst().seq < i - l + 1) {
                queue.removeFirst();
            }

            sb.append(queue.peekFirst().value).append(" ");
        }

        System.out.println(sb.toString());

    }
}
