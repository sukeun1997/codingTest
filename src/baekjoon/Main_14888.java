package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_14888 {

    static int operator[] = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int t = 0;
    static int operator_num[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        t = sc.nextInt();

        operator_num = new int[t];

        for (int i = 0; i < t; i++) {
            operator_num[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        bfs(1,operator_num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void bfs(int i, int result) {

        if (i == t) {
            if (result > max) {
                max = result;
            }

            if (result < min) {
                min = result;
            }
            return;
        }

        for (int j = 0; j < 4; j++) {
            if (operator[j] > 0) {
                operator[j] --;
                switch (j) {
                    case 0:
                        bfs(i+1,result + operator_num[i]);
                        break;
                    case 1:
                        bfs(i+1,result - operator_num[i]);
                        break;
                    case 2:
                        bfs(i+1,result * operator_num[i]);
                        break;
                    case 3:
                        bfs(i+1,result / operator_num[i]);
                        break;
                }
                operator[j]++;
            }
        }


    }
}
