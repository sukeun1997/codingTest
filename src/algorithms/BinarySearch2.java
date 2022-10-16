package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch2 {
    public int findTarget(int[] arr, int target) {


        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] >= arr[l]) {
                if (target >= arr[l] && target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= arr[r] && target > arr[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return arr[l] == target ? l : -1;
    }

    @Test
    void test() {
        assertEquals(findTarget(new int[]{4, 5, 6, 0, 1, 2,3}, 3), 6);
        assertEquals(findTarget(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), 4);
        assertEquals(findTarget(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1);
        assertEquals(findTarget(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1);
        assertEquals(findTarget(new int[]{1}, 0), -1);
    }
}
