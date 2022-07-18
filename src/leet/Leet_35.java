package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  Search Insert Position
 */
public class Leet_35 {

    public int searchInsert(int[] a, int target) {
        int l = 0, r = a.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if(a[mid] == target) return mid;
            else if (a[mid] > target) r = mid - 1;
            else l = mid + 1;
        }

        return l;
    }


    @Test
    void test() {
        Assertions.assertEquals(searchInsert(new int[]{1, 3, 5, 6}, 2), 1);

    }
}
