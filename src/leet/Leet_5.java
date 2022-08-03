package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet_5 {

    int lo = 0;
    int hi = 0;

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length() - 1; i++) {
            isPalindromic(i, i, s.toCharArray());
            isPalindromic(i, i + 1, s.toCharArray());
        }

        return s.substring(lo, lo+hi);
    }

    private void isPalindromic(int start, int end, char[] toCharArray) {

        while (start >= 0 && end < toCharArray.length && toCharArray[start] == toCharArray[end]) {
            start--;
            end++;
        }

        if (hi < end - start - 1) {
            lo = start + 1;
            hi = end - start - 1;
        }

    }

    @Test
    void test() {
//        Assertions.assertEquals(longestPalindrome("babad"), "bab");
        Assertions.assertEquals(longestPalindrome("cbbd"), "bb");
    }


}
