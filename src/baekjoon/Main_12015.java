package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int lis[] = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int lengthLis = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > lis[lengthLis - 1]) {
                lis[lengthLis] = arr[i];
                lengthLis++;
            } else {
                changeLis(lis, arr[i], lengthLis);
            }
        }

        System.out.println(lengthLis);
    }

    private static void changeLis(int[] lis, int i, int length) {
        int l  = 0;
        int r = length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (lis[mid] >= i) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        lis[l] = i;
    }
}
