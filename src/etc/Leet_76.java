package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Minimum Window Substring
 */
public class Leet_76 {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int counter =  t.length(); // check whether the substring is valid
        int l = 0, r = 0; //two pointers, one point to tail and one  head
        int minLen = Integer.MAX_VALUE; //the length of substring
        int minIdx = 0;

        for (char c : t.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
       }


        while (r < s.length()) {

            char key = s.charAt(r);
            if (hashMap.containsKey(key)) {
                if (hashMap.get(key) > 0) {
                    counter--;
                }
                hashMap.put(key, hashMap.get(key) - 1);
            }
            r++;

            while (counter == 0) {

                if (r - l < minLen) {
                    minLen = r - l;
                    minIdx = l;
                }

                char c = s.charAt(l);
                if (hashMap.containsKey(c)) {
                    hashMap.put(c, hashMap.get(c) + 1);
                    if (hashMap.get(c) > 0) {
                        counter++;
                    }
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIdx, minIdx + minLen);
    }


    @Test
    void test() {
        Assertions.assertEquals(minWindow("ADOBECODEBANC", "ABC"), "BANC");
    }
}
