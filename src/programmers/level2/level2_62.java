package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class level2_62 {

    // info = 1~50000
    // query = 1~100,000
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (String s : info) {
            String[] strings = s.split(" ");
            dfs(0, "", strings, map);
        }

        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }

        answer = new int[query.length];

        for (int i = 0; i < query.length; i++) { // m

            String s = query[i].replaceAll(" and ", "");
            String[] split = s.split(" ");
            String key = split[0];
            int value = Integer.parseInt(split[1]);

            if (map.containsKey(key)) {
                ArrayList<Integer> integers = map.get(key);

                answer[i] = binarySearch(integers, value); // logn
            } else {
                answer[i] = 0;
            }

        }



        return answer;
    }

    private int binarySearch(ArrayList<Integer> integers, int value) {

        int l = 0;
        int r = integers.size();

        while (l < r) {
            int mid = (l + r) / 2;

            if (integers.get(mid) < value) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return integers.size() - l;
    }

    private void dfs(int idx, String s, String[] strings, HashMap<String, ArrayList<Integer>> map) {

        if (idx == 4) {
            ArrayList<Integer> get = map.getOrDefault(s, new ArrayList<>());
            get.add(Integer.parseInt(strings[4]));
            map.put(s, get);
            return;
        }

        dfs(idx + 1, s + strings[idx],strings, map);
        dfs(idx + 1, s + "-", strings, map);
    }


    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"})
        , new int[]{1,1,1,1,2,4});

    }
}
