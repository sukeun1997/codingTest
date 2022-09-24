package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class etc20 {

    public String solution(int k, String[] dic, String chat) {
        StringBuilder sb = new StringBuilder();

        String[] words = chat.split(" ");
        Set<String> dics = new HashSet<>();

        for (String s : dic) {
            dics.add(s);
        }

        for (String word : words) {

            String filter = "";
            if (dics.contains(word)) {  // 완벽히 일치
                filter = word.replaceAll("[a-z]",  "#");
            } else if(word.contains(".")) { // . 을 포함
                String compile = Pattern.compile("[a-z]{1,"+k+"}").pattern();
                String s = word.replaceAll("[.]", compile);
                if (dics.stream().anyMatch(s1 -> s1.matches(s))) {
                    filter = word.replaceAll("[a-z]", "#").replaceAll(".", "#");
                } else {
                    filter = word;
                }
            } else {
                filter = word;
            }


            sb.append(filter).append(" ");
        }


        return sb.toString();
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(1,new String[]{"badwords"}, "bad.words badwords ba.words"), "");
    }

}
