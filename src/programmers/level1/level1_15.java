package programmers.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 키패드 누르기
 */
public class level1_15 {

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        HashMap<Integer, Hand> keyPad = new HashMap<>();
        HashMap<Integer, String> push = new HashMap<>();

        push.put(1, "L");
        push.put(4, "L");
        push.put(7, "L");
        push.put(3, "R");
        push.put(6, "R");
        push.put(9, "R");
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                keyPad.put(i, new Hand(i / 3 - 1, 2));
            } else {
                keyPad.put(i, new Hand(i / 3, i % 3 - 1));
            }
        }
        keyPad.put(0, new Hand(3, 1));

        Hand left = new Hand(3, 0);
        Hand right = new Hand(3, 2);

        for (int number : numbers) {

            if (push.containsKey(number)) {
                String useHand = push.get(number);
                answer.append(useHand);

                if (useHand.equals("R")) {
                    right = keyPad.get(number);
                } else {
                    left = keyPad.get(number);
                }
                continue;
            }

            int leftD = left.getDistance(keyPad.get(number));
            int rightD = right.getDistance(keyPad.get(number));

            if (leftD == rightD) {
                if (hand.equals("right")) {
                    right= keyPad.get(number);
                } else {
                    left = keyPad.get(number);
                }
                answer.append(hand.toUpperCase().charAt(0));
            } else {
                if (leftD > rightD) {
                    answer.append("R");
                    right = keyPad.get(number);
                } else {
                    answer.append("L");
                    left = keyPad.get(number);
                }
            }
        }

        return answer.toString();
    }

    private class Hand {
        int x, y;

        public Hand(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Hand hand) {
            return Math.abs(this.x - hand.x) + Math.abs(this.y - hand.y);
        }
    }

    @Test
    void test() {
//        Assertions.assertEquals(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"), "LRLLLRLLRRL");
        Assertions.assertEquals(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"), "LRLLRRLLLRR");
    }
}
