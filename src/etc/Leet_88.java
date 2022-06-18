package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leet_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int i1 = m - 1;
        int i2 = n - 1;
        int idx = m + n - 1;

        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[idx] = nums1[i1];
                i1--;
                idx--;
            } else {
                nums1[idx] = nums2[i2];
                i2--;
                idx--;
            }
        }

        while (i2 >= 0) {
            nums1[idx] = nums2[i2];
            i2--;
            idx--;
        }

    }

}
