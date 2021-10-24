package programmers;

import java.util.Arrays;

public class level1_1 {
    public String solution(String[] seoul) {

        int count = 0;
        for (String s : seoul) {
            if (s.equals("Kim")) {
                count++;
            }
        }
        String answer = "김서방은"+count+"에";
        return answer;
    }
}
