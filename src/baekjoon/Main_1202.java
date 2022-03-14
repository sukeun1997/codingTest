package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 보석 도둑
 */
public class Main_1202 {

    static class Shop {
        int m, v;

        public Shop(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        ArrayList<Shop> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int[] bag = new int[k];

        for (int i = 0; i  < n; i++) {
            String[] split = br.readLine().split(" ");
            list.add(new Shop(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        Collections.sort(list , (o1, o2) -> o1.m-o2.m);

        for (int i = 0; i < k; i++) {
            bag[i] = (Integer.parseInt(br.readLine()));
        }
        Arrays.sort(bag);

        long sum = 0;

        for (int i = 0, j = 0; i < k; i++) {

            while (j < n && list.get(j).m <= bag[i]) {
                queue.add(list.get(j++).v);
            }

            if (!queue.isEmpty()) {
                sum += queue.poll();
            }
        }

        System.out.println(sum);

    }
}
