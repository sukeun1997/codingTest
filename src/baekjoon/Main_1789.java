package baekjoon;

import java.util.Scanner;

public class Main_1789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();

        int m = 1;
        while (s * 2 >= Math.pow(m,2) + m) {
            m++;
        }
        System.out.println(m-1);
    }
}
