package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_2002_2 {

    int max = 0;

    public int maxProduct(String s) {

        dfs(s.toCharArray(), 0, new ArrayList<Character>(), new ArrayList<Character>());


        return max;
    }

    private void dfs(char[] array, int seq, ArrayList<Character> c1, ArrayList<Character> c2) {

        if (seq >= array.length) {
            if (isPalindromic(c1) && isPalindromic(c2)) {
                max = Math.max(max, c1.size() * c2.size());
            }
            return;
        }

        c1.add(array[seq]);
        dfs(array, seq + 1, c1, c2);

        c1.remove(c1.size() - 1);
        c2.add(array[seq]);
        dfs(array, seq + 1, c1, c2);


        c2.remove(c2.size() - 1);
        dfs(array, seq + 1, c1, c2);


    }


    public boolean isPalindromic(List<Character> list) {

        int lo = 0;
        int hi = list.size() - 1;

        while (lo < hi) {
            if (list.get(lo) != list.get(hi)) {
                return false;
            }
            lo++;
            hi--;
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
