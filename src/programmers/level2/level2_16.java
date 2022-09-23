package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class level2_16 {
    public boolean solution(String[] phone_book) {
        HashMap<String , Integer> hashMap = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i],i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length() ; j++) {
                String s = phone_book[i].substring(0, j);
                if (hashMap.containsKey(s)) {
                    return false;
                }
            }

        }

        return true;
    }

    @Test
    public void test() {
//        assertEquals("12345".contains("123"),true);
        assertEquals(solution(new String[]{"119", "97674223", "1195524421"}),false);
        assertEquals(solution(new String[]{"123","456","789"}),true);
        assertEquals(solution(new String[]{"12","123","1235","567","88"}),false);
        assertEquals(solution(new String[]{"113333","115555","345555","555555", "345444"}),true);
    }
}