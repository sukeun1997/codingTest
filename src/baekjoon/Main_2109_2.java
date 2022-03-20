package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 순회강연 re
 */
public class Main_2109_2 {

    static class Teach {
        int p, d;

        public Teach(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        ArrayList<Teach> arrayList = new ArrayList<>();
        boolean day[] = new boolean[10001];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            arrayList.add(new Teach(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        Collections.sort(arrayList, (o1, o2) -> {
            if (o1.p == o2.p) {
                return o1.d - o2.d;
            }
            return o2.p - o1.p;
        });

        int sum = 0;

        for (int i = 0; i < n; i++) {

            Teach teach = arrayList.get(i);

            int d = teach.d;
            int p = teach.p;

            for (int j = d; j >= 1 ; j--) {
                if (!day[j]) {
                    day[j] = true;
                    sum += p;
                    break;
                }
            }
        }
        System.out.println(sum);



    }
}
