package algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 8, 9, 2, 4, 7};
        quick_sort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(value -> System.out.print(value + " "));
    }

    private static void quick_sort(int[] a, int left, int right) {

        if (left >= right) {
            return;
        }

        int pivot_idx = partition(a, left, right);

        quick_sort(a,left,pivot_idx-1);
        quick_sort(a,pivot_idx+1,right);


    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[left];
        int lo = left;
        int hi = right;

        while (lo < hi) {

            // 피벗보다 작은 값을 찾는다
            while (pivot < a[hi] && lo < hi) {
                hi--;
            }

            // 피벗 보다 큰 값을 찾는다
            while (pivot >= a[lo] && lo < hi) {
                lo++;
            }

            swap(a, lo, hi);
        }

        swap(a,left,lo);

        return lo;
    }

    private static void swap(int[] a, int lo, int hi) {
        int temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }

    @Test
    void test() {
        partition(new int[]{5, 3, 8, 9, 2, 4, 7}, 0, 6);
    }
}
