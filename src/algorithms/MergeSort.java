package algorithms;

import java.util.Arrays;

public class MergeSort {

    private static int[] sorted;

    public static void main(String[] args) {
        int[] array = {8, 2, 6, 4, 7, 3, 9, 5};
        merge_sort(array);
        System.out.println(array);
    }
    public static void merge_sort(int[] a) {
        sorted = new int[a.length];
        merge_sort(a,0,a.length-1);
        sorted = null;
    }

    private static void merge_sort(int[] a, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;

            merge_sort(a, left, mid);
            merge_sort(a, mid + 1, right);
            merge(a, left, mid, right);
        }

    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid +1;
        int idx = left;

        while (l <= mid && r <= right) {

            if (a[l] < a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        // 왼쪽이 먼저 채워진 경우
        if (l > mid) {
            while (r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];

        }

    }

}
