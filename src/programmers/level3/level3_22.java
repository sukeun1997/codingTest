package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 다단계 칫솔 판매
 */
public class level3_22 {

    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> income = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];


        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            income.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            sell(seller[i], amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = income.get(enroll[i]);
        }

        return answer;
    }

    private void sell(String seller, int money) {

        if (seller.equals("-") || money == 0) {
            return;
        }

        int fee = money / 10;
        income.put(seller, income.get(seller) + money - fee);
        sell(parent.get(seller), fee);
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
