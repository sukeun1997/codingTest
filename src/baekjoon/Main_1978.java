package baekjoon;

import java.util.Scanner;

public class Main_1978 {
    static int N[] = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int count[] = new int[T];
        for (int i = 0; i < T; i++) {
            count[i] = sc.nextInt();
        }
        for (int i = 2; i <= 31; i++) {
            if(N[i] == -1)
                continue;
            for (int l = i*i; l <= 1000; l++) {
                if (l % i == 0 && l != i) {
                    N[l] = -1;
                }
            }
        }
        int num = 0;

        for (int x : count) {
            if (isPrime(x)) {
                num++;
            }
        }
        System.out.println(num);


    }

    public static boolean isPrime(int x){
        if (N[x] == 0 && x != 1) {
            return true;
        } else {
            return false;
        }
    }
}
