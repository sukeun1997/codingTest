package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet_209_2 {

    public int minSubArrayLen(int target, int[] nums) {

        int ans = Integer.MAX_VALUE;
        int lo = 0;
        int sum = 0;
        int fir = 0;

        while (lo < nums.length) {

            sum += nums[lo++];

            while (sum - nums[fir] >= target) {
                sum -= nums[fir];
                fir++;
            }
            if (sum >= target)
                ans = Math.min(ans, lo - fir);
        }

        if (sum < target) {
            return 0;
        } else {
            return ans;
        }
    }

    @Test
    void test() {
        Assertions.assertEquals(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}), 2);
        Assertions.assertEquals(minSubArrayLen(7, new int[]{1, 1, 1}), 0);
        Assertions.assertEquals(minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}), 2);
    }
}
