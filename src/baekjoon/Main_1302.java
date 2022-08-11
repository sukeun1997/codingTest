package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main_1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> treeMap = new TreeMap<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            String key = br.readLine();
            treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);

            if (max < treeMap.get(key)) {
                max = treeMap.get(key);
            }
        }

        for (String s : treeMap.keySet()) {
            if (treeMap.get(s) == max) {
                System.out.println(s);
                return;
            }
        }
    }
}
