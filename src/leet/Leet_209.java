package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Minimum Size Subarray Sum
 */
public class Leet_209 {

    public int minSubArrayLen(int target, int[] nums) {

        int l = 0;

        int sum = 0;
        int first = 0;
        int answer = Integer.MAX_VALUE;
        while (l < nums.length) {
            sum += nums[l++];

            while (sum - nums[first] >= target) {
                sum -= nums[first];
                first++;
            }

            if (sum >= target) {
                answer = Math.min(answer, l - first);
            }

        }

        if (sum < target) {
            return 0;
        }
        return  answer;
    }



    @Test
    void test() {
        Assertions.assertEquals(minSubArrayLen(7, new int[]{2,3,1,2,4,3}),2);
        Assertions.assertEquals(minSubArrayLen(7, new int[]{1,1,1}),0);
        Assertions.assertEquals(minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}),2);
    }
}