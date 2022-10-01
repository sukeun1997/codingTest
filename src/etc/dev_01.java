package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dev_01 {

    public String solution(String[] registered_list, String new_id) {

        Set<String> strings = new HashSet<>();

        for (String s : registered_list) {
            strings.add(s);
        }


        while (strings.contains(new_id)) {

            Matcher matcher = Pattern.compile("[1-9]\\d{0,5}").matcher(new_id);
            if (matcher.find()) {
                int i = Integer.parseInt(matcher.group()) + 1;
                new_id = matcher.replaceAll(String.valueOf(i));

            } else {
                new_id += "1";
            }
        }


        return new_id;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(new String[]{"card","ace13","ace16","banker","ace17","ace14"}, "ace15"), "ace15");
        Assertions.assertEquals(solution(new String[]{"cow","cow1","cow2","cow3","cow4","cow5","cow6","cow7","cow8","cow9"}, "cow"), "cow10");
        Assertions.assertEquals(solution(new String[]{"bird99","bird98","bird101"}, "bird98"), "bird100");
    }
}
