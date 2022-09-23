package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class level2_13 {


    public String solution(int[] numbers) {
        String answer = "";
        //문자열 리턴을 해줄 스트링배열 생성
        String[] str = new String[numbers.length];

        //int배열 String배열로 변환
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (str[0].equals("0")) {
            return "0";
        }

        for (String s : str) {
            answer += s;
        }

        return answer;
    }


    @Test
    public void test() {
        assertTrue(solution(new int[]{6,10,2}).equals("6210"));
        assertTrue(solution(new int[]{3, 30, 34, 5, 9}).equals("9534330"));
    }
}
