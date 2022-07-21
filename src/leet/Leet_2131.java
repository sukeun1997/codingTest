package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Leet_2131 {


    public int longestPalindrome(String[] words) {

        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < words.length; i++) {


            String word = "" + words[i].charAt(1) + words[i].charAt(0);
            if (map.containsKey(word)) {
                ans += 4;
                map.put(word, map.get(word) - 1);
                if (map.get(word) == 0) {
                    map.remove(word);
                }
                continue;
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        for (String s : map.keySet()) {
            if (s.charAt(0) == s.charAt(1)) {
                ans += 2;
                break;
            }
        }

        return ans;
    }


    @Test
    void test() {
        Assertions.assertEquals(longestPalindrome(new String[]{"lc", "cl", "gg"}), 6);
        Assertions.assertEquals(longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}), 8);
        Assertions.assertEquals(longestPalindrome(new String[]{"cc", "ll", "xx"}), 2);
    }
}
