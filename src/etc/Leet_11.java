package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Container With Most Water
 */
public class Leet_11 {

    public int maxArea(int[] height) {
        int answer = 0;
        int h = 0;
        int r = height.length - 1;

        while (h < r) {
            answer = Math.max(answer, (r - h) * Math.min(height[r], height[h]));

            if (height[h] > height[r]) {
                r--;
            } else {
                h++;
            }
        }

        return answer;
    }


    @Test
    void test() {
        Assertions.assertEquals(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
        Assertions.assertEquals(maxArea(new int[]{1, 1}), 1);
    }
}
