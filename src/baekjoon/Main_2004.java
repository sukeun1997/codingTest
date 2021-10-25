package baekjoon;

import java.util.Scanner;

public class Main_2004 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int FiveCount = FindFive(N) - FindFive(M) - FindFive(N - M);
        int TwoCount = FindTwo(N) - FindTwo(M) - FindTwo(N - M);

        System.out.println(Math.min(FiveCount,TwoCount));

    }

    static int FindFive(int num) {
        int result = 0;
        while(num >= 5) {
            result += num / 5;
            num /= 5;
        }
        return result;
    }

    static int FindTwo(int num) {
        int result = 0;
        while(num >= 2) {
            result += num / 2;
            num /= 2;
        }
        return result;
    }
}
