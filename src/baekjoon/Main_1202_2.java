package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1202_2 {


    static class Coin implements Comparable<Coin> {

        int m, v;

        public Coin(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Coin o) {
            return o.v - this.v;
        }
    }

    private static int[] bags;
    private static PriorityQueue<Coin> queue = new PriorityQueue<>();
    private static ArrayList<Coin> list = new ArrayList<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        long answer = 0;


        String[] strings = br.readLine().split(" ");
        // 1~300,000
        int n = Integer.valueOf(strings[0]);
        int k = Integer.valueOf(strings[1]);

        bags = new int[k];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            list.add(new Coin(Integer.valueOf(s[0]), Integer.valueOf(s[1])));
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(bags);
        Collections.sort(list, Comparator.comparingInt(o -> o.m));

        for (int i = 0, j = 0; i < k; i++) {
            int weight = bags[i];

            while (j < n && list.get(j).m <= weight) {
                queue.add(list.get(j++));
            }

            if (!queue.isEmpty()) {
                answer += queue.poll().v;
            }
        }

        System.out.println(answer);

    }
}
