package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Leet_76_2 {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        int min = 0;
        int minLen = Integer.MAX_VALUE;

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        int count = t.length();
        while (l < s.length()) {
            char c = s.charAt(l);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c) - 1);
            }
            l++;

            while (count == 0) {

                if (l - r < minLen) {
                    minLen = l - r;
                    min = r;
                }
                char c1 = s.charAt(r);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);

                    if (map.get(c1) > 0) {
                        count++;
                    }
                }

                r++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(min, min + minLen);
    }

    @Test
    void test() {
        Assertions.assertEquals(minWindow("ADOBECODEBANC", "ABC"), "BANC");
    }

}
