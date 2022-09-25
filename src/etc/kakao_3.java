package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class kakao_3 {

    // 정렬
    // 할인율 10,20,30,40
    // user 1~ 100
    // emotions 1~7
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }

            return o2[0] - o1[0];
        });


        dfs(0, users, emoticons, queue, new int[8]);


        return !queue.isEmpty() ? queue.peek() : new int[]{0, 0};
    }

    int[] discounts = new int[]{10, 20, 30, 40};

    private void dfs(int idx, int[][] users, int[] emoticons, PriorityQueue<int[]> queue, int[] discount) {
        if (idx == emoticons.length) {

            int invite = 0;
            int totalMoney = 0;

            for (int i = 0; i < users.length; i++) {
                int money = 0;

                for (int j = 0; j < emoticons.length; j++) {
                    if (users[i][0] <= discount[j]) {
                        money += emoticons[j] - (emoticons[j] * discount[j] / 100);
                    }
                }

                if (money >= users[i][1]) {
                    invite++;
                } else {
                    totalMoney += money;
                }
            }

            queue.add(new int[]{invite, totalMoney});
            return;
        }


        for (int j = 0; j < 4; j++) {
            discount[idx] = discounts[j];
            dfs(idx + 1, users, emoticons, queue, discount);
        }


    }


    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000}), new int[]{1, 5400});
    }
}
