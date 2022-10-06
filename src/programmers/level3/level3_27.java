package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 보석 쇼핑
 */
public class level3_27 {

    public int[] solution(String[] gems) {
        int[] answer = new int[]{0, 0};

        int kind = new HashSet<>(Arrays.asList(gems)).size();
        HashMap<String, Integer> buys = new HashMap<>();

        int l = 0;

        int length = Integer.MAX_VALUE;
        for (int r = 0; r < gems.length; r++) {
            buys.put(gems[r], buys.getOrDefault(gems[r], 0) + 1);

            while (buys.get(gems[l]) > 1) {
                buys.put(gems[l], buys.get(gems[l]) - 1);
                l++;
            }

            if (kind == buys.size() && length > (r-l)) {
                length = r - l;
                answer[0] = l + 1;
                answer[1] = r + 1;
            }

        }



        return answer;
    }

    @Test
    void test() {

        Assertions.assertArrayEquals(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}), new int[]{3,7});
        Assertions.assertArrayEquals(solution(new String[]{"AA", "AB", "AC", "AA", "AC"}), new int[]{1,3});
        Assertions.assertArrayEquals(solution(new String[]{"XYZ", "XYZ", "XYZ"}), new int[]{1,1});
        Assertions.assertArrayEquals(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}), new int[]{1,5});
    }
}
