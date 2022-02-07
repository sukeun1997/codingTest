package etc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 모험가 길드
 */
public class etc14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int list[] = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);

        int answer = 0;
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            count++;
            if (list[i] <= count) {
                answer++;
                count = 0;
            }
        }

        System.out.println(answer);


    }
}
