package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Search in Rotated Sorted Array
 */
public class Leet_33 {

//    public int search(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }

    @Test
    void test() {
        assertEquals(search(new int[]{4, 5, 6, 0, 1, 2,3}, 3), 3);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), 4);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1);
        assertEquals(search(new int[]{1}, 0), -1);
    }
}
