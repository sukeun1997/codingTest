package algorithms;

/**
 * 삽입 정렬
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {8, 2, 6, 4, 7, 3, 9, 5};
        insertion_sort(array);
        System.out.println();
    }

    public static void insertion_sort(int[] a) {
        insertion_sort(a, a.length);
    }

    private static void insertion_sort(int[] a, int size) {

        for (int i = 1; i < size ; i++) {

            int target = a[i];

            int j = i - 1;

            while (j >= 0 && a[j] > target) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = target;
        }

    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
