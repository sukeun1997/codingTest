package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Leet_3_2 {

    public int lengthOfLongestSubstring(String s) {

        int l = s.length(); int r = 0; int d = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int answer = 0;
        while (r < l) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.get(c) > 1) {
                while (d < l && map.get(c) != 1) {
                    char key = s.charAt(d);
                    map.put(key, map.get(key) - 1);
                    d++;
                }

            }

            r++;
            answer = Math.max(answer, r - d);

        }

        return answer;
    }


    @Test
    void test() {
//        Assertions.assertEquals(lengthOfLongestSubstring("abcabcabc"), 3);
//        Assertions.assertEquals(lengthOfLongestSubstring("bbbbb"), 1);
//        Assertions.assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
        Assertions.assertEquals(lengthOfLongestSubstring(" "), 1);
        Assertions.assertEquals(lengthOfLongestSubstring("a"), 1);
    }
}
