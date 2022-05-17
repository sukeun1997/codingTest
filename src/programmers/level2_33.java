package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 뉴스 클러스터링
 */
public class level2_33 {

    public int solution(String str1, String str2) {

        List<String> a = new LinkedList<>();
        List<String> b = new LinkedList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        float common = 0;
        float sum = 0;

        setUnion(str1, a);
        setUnion(str2, b);

        for (String s : a) {
            if (b.contains(s)) {
                b.remove(s);
                common++;
            }
        }

        sum += a.size() + b.size();




        if (sum == 0 && common == 0) {
            return 65536;
        }
        return (int) Math.floor(common / sum * 65536);
    }

    private void setUnion(String str1, List<String> a) {
        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.charAt(i) + "" + str1.charAt(i + 1);
            if (isAlpha(s)) {
                a.add(s);
            }
        }
    }


    private boolean isAlpha(String substring) {
        Pattern p = Pattern.compile("[a-z]{2}");
        Matcher m = p.matcher(substring);
        return m.matches();
    }

    @Test
    void test() {
        Assertions.assertEquals(solution("FRANCE", "french"), 16384);
        Assertions.assertEquals(solution("handshake", "shake hands"), 65536);
        Assertions.assertEquals(solution("aa1+aa2", "AAAA12"), 43690);
        Assertions.assertEquals(solution("E=M*C^2", "e=m*c^2"), 65536);
        Assertions.assertEquals(solution("BAAAA", "AAA"), 32768);
        Assertions.assertEquals(solution("abc", "abbb"), 16384);
    }
}
