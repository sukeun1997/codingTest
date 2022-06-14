package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 */
public class Leet_3 {
   /* public int lengthOfLongestSubstring(String s) {
        int answer = 0;

        Set<Character> set;

        int length = s.length();
        for (int i = 0; i < length; i++) {
            set = new HashSet<>();

            for (int j = i; j < length; j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
            }
            answer = Math.max(answer, set.size());
        }
        return answer;
    }*/

    /**
     * 더 빠른 풀이
     */

    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int length = s.length();
        int l = 0, r = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        while (r < length) {
            char key = s.charAt(r);
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            r++;
            while (l < length && hashMap.get(key) > 1) {
                char c = s.charAt(l);
                hashMap.put(c, hashMap.get(c) - 1);
                l++;
            }
            answer = Math.max(answer, r - l);
        }

        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(lengthOfLongestSubstring("abcabcabc"), 3);
        Assertions.assertEquals(lengthOfLongestSubstring("bbbbb"), 1);
        Assertions.assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
        Assertions.assertEquals(lengthOfLongestSubstring(" "), 1);
        Assertions.assertEquals(lengthOfLongestSubstring("a"), 1);
    }
}
