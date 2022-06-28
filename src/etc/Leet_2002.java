package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Maximum Product of the Length of Two Palindromic Subsequences
 */


public class Leet_2002 {
    int max = 0;

    public int maxProduct(String s) {

        dfs(s.toCharArray(), 0, new ArrayList<Character>(), new ArrayList<Character>());

        return max;
    }

    private void dfs(char[] c, int i, ArrayList<Character> s, ArrayList<Character> s2) {

        if (c.length <= i) {
            if (isPaling(s) && isPaling(s2))
                max = Math.max(max, s.size() * s2.size());
            return;
        }

        s.add(c[i]);
        dfs(c, i + 1, s, s2);

        s.remove(s.size() - 1);
        s2.add(c[i]);
        dfs(c, i + 1, s, s2);

        s2.remove(s2.size() - 1);
        dfs(c, i + 1, s, s2);
    }

    private boolean isPaling(ArrayList<Character> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            if (list.get(start) == list.get(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
/*        Assertions.assertEquals(maxProduct("bb"), 1);
        Assertions.assertEquals(maxProduct("accaxcx"), 12);*/
        Assertions.assertEquals(maxProduct("leetcodecom"), 9);
        Assertions.assertEquals(maxProduct("accbcaxxcxx"), 25);
    }
}
