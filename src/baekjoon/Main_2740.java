package baekjoon;

import java.util.Scanner;

public class Main_2740 {
    static int A[][];
    static int B[][];
    static int C[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt(), y1 = sc.nextInt();

        A = new int[x1][y1];

        for (int i = 0; i < x1; i++) {
            for (int l = 0; l < y1; l++) {
                A[i][l] = sc.nextInt();
            }
        }

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        B = new int[x2][y2];

        for (int i = 0; i < x2; i++) {
            for (int l = 0; l < y2; l++) {
                B[i][l] = sc.nextInt();
            }
        }
        C = new int[x1][y2];
        calc(x1,y1,x2,y2);

        for (int i = 0; i < x1; i++) {
            for (int l = 0; l < y2; l++) {
                System.out.print(C[i][l]+" ");
            }
            System.out.println();
        }

    }

    public static void calc(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < x1; i++) {
            for (int l = 0; l < y2; l++) {
                C[i][l] = A[l][i] * B[i][l];
            }
        }
    }
}
