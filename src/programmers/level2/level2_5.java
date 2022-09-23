package programmers.level2;

import java.util.*;

public class level2_5 {


    public static int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        int[] answer = {};
        answer = new int[msg.length()];

        for (int i = 65; i <= 90 ; i++) {
            map.put(String.valueOf((char) i), i - 64);
        }

        String[] msgs = msg.split("");


        int count = 0;
        boolean flag = false;

        for (int i = 0; i < msgs.length; i++) {
            if (flag) {
                break;
            }
            String w = msgs[i];
            for (int j = i+1; j <= msgs.length; j++) {

                if (j == msgs.length) {
                    answer[count] = map.get(w);
                    flag = true;
                    break;
                }
                String c = msgs[j];
                if (!map.containsKey(w + c)) {
                    map.put(w + c, map.size() + 1);
                    answer[count] = map.get(w);
                    count++;
                    i = j-1;
                    break;
                }

                w = w+c;
            }
        }

        answer = Arrays.stream(answer).filter(value -> value != 0).toArray();
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        solution(sc.nextLine());
    }
}
