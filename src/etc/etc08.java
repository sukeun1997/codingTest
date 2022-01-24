package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 부품 찾기 (이진탐색)
 */
public class etc08 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int list[] = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.valueOf(s[i]);
        }

        // 정렬 필수
        Arrays.sort(list);

        int m = Integer.valueOf(br.readLine());
        s = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            Integer find = Integer.valueOf(s[i]);
            boolean search = binarySearch(list, find, 0, n - 1);

            if (search) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }

    }

    private static boolean binarySearch(int[] list, Integer find, int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list[mid] == find) {
                return true;
            } else if (list[mid] > find) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;

    }
}
