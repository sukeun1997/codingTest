package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Find First and Last Position of Element in Sorted Array
 */
public class Leet_34 {

    public int[] searchRange(int[] a, int target) {
        int lo = 0;
        int hi = a.length - 1;

        if (a.length == 0) {
            return new int[]{-1, -1};
        }
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (target > a[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        if (a[lo] != target) {
            return new int[]{-1, -1};
        }

        int l2 = lo;
        hi = a.length - 1;
        while (l2 < hi) {
            int mid = (l2 + hi) / 2 + 1;

            if (target < a[mid]) {
                hi = mid - 1;
            } else {
                l2 = mid;
            }
        }

        return new int[]{lo, hi};
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
