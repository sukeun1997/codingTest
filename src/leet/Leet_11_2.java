package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet_11_2 {


    public int maxArea(int[] a) {

        int max = 0 ;
        int l = 0;
        int r = a.length-1;


        while (l < r) {
            max = Math.max(max, (r - l) * (a[l] > a[r] ? a[r] : a[l]));
            if (a[l] > a[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    @Test
    void test() {
        Assertions.assertEquals(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
        Assertions.assertEquals(maxArea(new int[]{1, 1}), 1);
    }
}
