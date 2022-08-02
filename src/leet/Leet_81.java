package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Search in Rotated Sorted Array II
 */
public class Leet_81 {

    public boolean search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                return true;
            } else if(nums[mid] == nums[lo]) {
                lo++;
            } else if (nums[mid] > nums[lo]) {
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }


    @Test
    void test() {

        Assertions.assertEquals(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0), true);
    }
}
