package etc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class etc01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int list[] = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        int count = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            if (count == k) {
                count = 0;
                sum += list[list.length - 2];
            } else {
                sum += list[list.length - 1];
                count++;
            }
        }
        System.out.println(sum);

    }
}
