package baekjoon;

import java.util.Scanner;

public class Main_15658 {

    static int t;
    static int number[];
    static int operator[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        number = new int[t];
        operator = new int[4];

        for (int i = 0; i < t; i++) {
            number[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        go(1, number[0]);
        System.out.println(max);
        System.out.println(min);

    }

    private static void go(int i, int result) {

        if (i == t) {
            if (max < result) {
                max = result;
            }

            if (min > result) {
                min = result;
            }
            return;
        }

        for (int j = 0; j < 4; j++) {
            if (operator[j] > 0) {
                operator[j]--;
                switch (j) {
                    case 0:
                        go(i + 1, result + number[i]);
                        break;
                    case 1:
                        go(i + 1, result - number[i]);
                        break;
                    case 2:
                        go(i + 1, result * number[i]);
                        break;
                    case 3:
                        go(i + 1, result / number[i]);
                        break;
                }
                operator[j]++;
            }
        }
    }
}
