package baekjoon;

import java.util.Scanner;

public class Main_2023 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dfs("", n);
    }

    private static void dfs(String string, int depth) {

        if (string.length() == depth) {
            System.out.println(string);
            return;
        }

        for (int i = 1; i < 10 ; i++) {
            if (isPrime(Integer.parseInt(string + i))) {
                dfs(string+i,depth);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
