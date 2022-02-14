package etc;

import java.util.Scanner;

/**
 * 볼링공 고르기
 */
public class etc16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = 0;

        int list[] = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }


        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n ; j++) {
                if (list[i] == list[j]) {
                    continue;
                }
                count++;
            }
        }

        System.out.println(count);
    }
}
