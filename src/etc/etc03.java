package etc;

import java.util.Scanner;

public class etc03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;
        while (n != 1) {

            count++;
            if (n % k == 0) {
                n = n / k;
            } else {
                n = n - 1;
            }
        }

        System.out.println(count);
    }
}
