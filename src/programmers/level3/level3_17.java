package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 다단계 칫솔 판매
 */
public class level3_17 {


    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int[] answer = new int[enroll.length];

        HashMap<String, String > parent = new HashMap<>();
        HashMap<String, Integer> my = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            my.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {

            String now = seller[i];
            int profit = (100 * amount[i]);

            while (!now.equals("-")) {
                int parentProfit = profit / 10;
                profit = profit - parentProfit;

                answer[my.get(now)] += profit;
                now = parent.get(now);
                profit = parentProfit;

                if (profit < 1) {
                    break;
                }
            }

        }

        return answer;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                        new String[]{"young", "john", "tod", "emily", "mary"},
                        new int[]{12, 4, 2, 5, 10}),
                new int[]{360, 958, 108, 0, 450, 18, 180, 1080});

        Assertions.assertArrayEquals(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                        new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                        new String[]{"sam", "emily", "jaimie", "edward"},
                        new int[]{2, 3, 5, 4}),
                new int[]{0, 110, 378, 180, 270, 450, 0, 0});
    }
}
