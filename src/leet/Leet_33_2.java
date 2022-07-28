package leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Leet_33_2 {

    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        int n = lo;
        lo = 0;
        hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int rm = (mid + n) % nums.length;

            if (nums[rm] == target) {
                return rm;
            } else if (nums[rm] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }

        return -1;
    }

    @Test
    void test() {
        assertEquals(search(new int[]{4, 5, 6, 0, 1, 2,3}, 3), 6);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), 4);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1);
        assertEquals(search(new int[]{1}, 0), -1);
    }
}
