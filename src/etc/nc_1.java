package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class nc_1 {

    public String solution(String source) {

        char[] chars = source.toCharArray();
        Arrays.sort(chars);
        source = String.valueOf(chars);

        StringBuilder dest = new StringBuilder();

        while (!source.isEmpty()) {

            StringBuilder sb = new StringBuilder();
            Set<Character> characters = new HashSet<>();

            for (int i = 0; i < source.length(); i++) {
                char c = source.charAt(i);
                if (!characters.contains(c)) {
                    characters.add(c);
                    dest.append(c);
                } else {
                    sb.append(c);
                }
            }

            source = sb.toString();
        }

        return dest.toString();

    }


    @Test
    void test() {
        Assertions.assertEquals(solution("execute"), "cetuxee");
        Assertions.assertEquals(solution("cucumber"), "bcemrucu");
        Assertions.assertEquals(solution("bbaabd"), "abdabb");
    }
}
