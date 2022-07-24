package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet_35_2 {

    public int searchInsert(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    @Test
    void test() {
        Assertions.assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 2), 1);

    }
}
