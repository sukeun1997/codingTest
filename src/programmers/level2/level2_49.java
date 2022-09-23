package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 모음사전
 */
public class level2_49 {

    char[] arr = new char[]{'A', 'E', 'I', 'O', 'U'};


    public int solution(String word) {

        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();

        dfs(sb, arrayList);
        return arrayList.indexOf(word) + 1;
    }
    private void dfs(StringBuilder sb, ArrayList<String> list) {
        if (sb.length() == 5) {
            return;
        }

        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]);
            list.add(sb.toString());
            dfs(sb, list);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(solution("AAAAE"), 6);
    }

}
