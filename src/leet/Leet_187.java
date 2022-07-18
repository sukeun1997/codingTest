package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Repeated DNA Sequences
 */
public class Leet_187 {

   /* public List<String> findRepeatedDnaSequences(String s) {
        int l = 0;
        int r = s.length();

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        while (l + 10 <= r) {
            String sub = s.substring(l, l + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);

            if (map.get(sub) == 2) {
                list.add(sub);
            }
            l++;
        }

        return list;
    }*/

    public List<String> findRepeatedDnaSequences(String s) {
        int l = 0;
        int r = s.length();

        Set<String> set = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        while (l + 10 <= r) {
            String sub = s.substring(l, l + 10);
            if (!set.add(sub)) {
                repeated.add(sub);
            }
            l++;
        }

        return new ArrayList<>(repeated);
    }
    @Test
    void test() {
        Assertions.assertEquals(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"), List.of("AAAAACCCCC","CCCCCAAAAA"));
        Assertions.assertEquals(findRepeatedDnaSequences("AAAAAAAAAAAAA"), List.of("AAAAAAAAAA"));
    }
}
