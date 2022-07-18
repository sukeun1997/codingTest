package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet_34_2 {

    public int[] searchRange(int[] nums, int target) {

        int[] answer = new int[2];

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {

            int mid = (lo + hi) / 2;

            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        if (nums[lo] != target) {
            return new int[]{-1, -1};
        }
        answer[0] = lo;
        int l2 = lo;
        hi = nums.length - 1;

        while (l2 < hi) {
            int mid = (l2 + hi) / 2 + 1;

            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                l2 = mid + 1;
            }

        }


        return new int[]{};
    }

    @Test
    void test() {
//        Assertions.assertEquals(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), 0);
//        Assertions.assertEquals(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), 0);
//        Assertions.assertEquals(searchRange(new int[]{2,2}, 2), 0);
//        Assertions.assertEquals(searchRange(new int[]{}, 2), 0);
        Assertions.assertEquals(searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3), 0);
    }
}
