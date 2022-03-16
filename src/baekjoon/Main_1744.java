package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 수 묶기
 */
public class Main_1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int minus = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;
            if (number < 0) {
                minus++;
            }
        }

        Arrays.sort(arr);

        long sum = 0;

        // 음수 끼리는 곱하기
        if (minus >= 2) {
            for (int i = 1; i < minus; i += 2) {
                sum += arr[i-1] * arr[i];
            }
        }
        // 음수 마지막 홀수 번째 더하기
        if (minus % 2 != 0) {
            // 음수 마지막 홀수이면서 양수 첫번째가 0
            if (n - minus >= 1) {
                if (arr[minus] == 0) {
                    minus++;
                } else {
                    sum += arr[minus - 1];
                }
            } else {
                sum += arr[minus - 1];
            }
        }

        int even = n - minus;
        // 양수 첫번째 홀수 번째 더하기
        if (even % 2 != 0) {
            sum += arr[minus];
        }

        // 양수 곱하기

        if (even >= 2) {
            if (even % 2 == 0) {
                for (int i = minus; i < n; i += 2) {
                    int n1 = arr[i] * arr[i + 1];
                    int n2 = arr[i] + arr[i + 1];


                    sum += n1 > n2 ? n1 : n2;
                }
            } else {
                for (int i = minus + 1; i < n; i += 2) {
                    int n1 = arr[i] * arr[i + 1];
                    int n2 = arr[i] + arr[i + 1];


                    sum += n1 > n2 ? n1 : n2;
                }
            }
        }

        System.out.println(sum);
    }
}
