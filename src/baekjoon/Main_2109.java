package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 순회강연
 */
public class Main_2109 {

    static class Teach implements Comparable<Teach> {
        int p, d;

        public Teach(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Teach o) {
            if (o.p == this.p) {
                return this.d - o.d;
            }
            return o.p - this.p;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Teach> queue = new PriorityQueue<>();


        int maxday = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int d = Integer.parseInt(s[1]);
            queue.add(new Teach(p, d));
            maxday = Math.max(maxday, d);

        }



        int sum = 0;
        boolean checked[] = new boolean[maxday+1];


        while (!queue.isEmpty()) {
            Teach poll = queue.poll();

            for (int i = poll.d; i >= 1; i--) {
                if (!checked[i]) {
                    checked[i] = true;
                    sum += poll.p;
                    break;
                }
            }

        }



        System.out.println(sum);



    }
}
