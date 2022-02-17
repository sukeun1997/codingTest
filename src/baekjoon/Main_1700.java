package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1700 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int order[] = new int[k];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(plug(n, k, order));


    }

    private static int plug(int n, int k, int[] order) {

        int count = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            int current = order[i];

            if(set.contains(current)) continue;
            if(set.size() < n && set.add(current)) continue;

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = i + 1; j < k ; j++) {
                if (set.contains(order[j]) && !arrayList.contains(order[j])) {
                    arrayList.add(order[j]);
                }
            }

            if (arrayList.size() != n) {
                Integer integer1 = set.stream().filter(integer -> !arrayList.contains(integer)).findFirst().get();
                set.remove(integer1);
            } else {
                set.remove(arrayList.get(arrayList.size() - 1));
            }
            set.add(current);
            count++;

        }


        return count;
    }
}
