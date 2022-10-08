package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 주식가격
 */
public class level2_65 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Stock> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {

            if (!queue.isEmpty()) {
                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    Stock stock = queue.poll();
                    stock.addTime();

                    if (prices[i] < prices[stock.idx]) {
                        answer[stock.idx] = stock.time;
                    } else {
                        queue.add(stock);
                    }
                }
            }

            queue.add(new Stock(i,0));
        }

        while (!queue.isEmpty()) {
            Stock stock = queue.poll();
            answer[stock.idx] = stock.time;
        }

        return answer;
    }

    private class Stock {
        int idx , time;

        public Stock(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }


        public void addTime() {
            time += 1;
        }
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(new int[]{1,2,3,2,3}), new int[]{4,3,1,1,0});
    }
}
