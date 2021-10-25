package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_14500 {

    static int list[][];
    static int max = Integer.MIN_VALUE;

    // shape 1 ,2 , 3 , 4 , 5
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        list = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                list[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= N - 3; i++) {
            for (int k = 1; k <= M - 3; k++) {
                // 일자 모양
                T1(i, k);
                // ㅁ자모양
                T2(i, k);
                // L 자 모양
                T3(i, k);
                // Z 모양
                T4(i, k);
                // ㅜ 모양
                T5(i, k);
            }

        }

        System.out.println(max);
    }

    private static void T5(int row, int col) {
        // ㅜ 모양
        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 1; j++) {
                int a = 0;
                a += list[i][j + 1] + list[i + 1][j + 1];
                if (list[i][j] + list[i][j + 2] > list[i + 1][j] + list[i + 1][j + 2]) {
                    a += list[i][j] + list[i][j + 2];
                } else {
                    a += list[i + 1][j] + list[i + 1][j + 2];
                }
                if (a > max) {
                    max = a;
                }
            }
        }

        // ㅏ 모양

        for (int i = row; i <= row + 1; i++) {
            for (int j = col; j <= col + 2; j++) {
                int a = 0;
                a += list[i + 1][j] + list[i + 1][j + 1];
                if (list[i][j] + list[i + 2][j] > list[i][j + 1] + list[i + 2][j + 1]) {
                    a += list[i][j] + list[i + 2][j];
                } else {
                    a += list[i][j + 1] + list[i + 2][j + 1];

                }
                if (a > max) {
                    max = a;
                }
            }

        }
    }

    private static void T4(int row, int col) {

        // z 자 위 모양
        for (int i = row; i <= row + 1; i++) {
            for (int j = col; j <= col + 2; j++) {
                int a = 0;
                a += list[i + 1][j] + list[i + 1][j + 1];

                if (list[i][j] + list[i + 2][j + 1] > list[i][j + 1] + list[i + 2][j]) {
                    a += list[i][j] + list[i + 2][j + 1];
                } else {
                    a += list[i][j + 1] + list[i + 2][j];
                }
                if (a > max) {
                    max = a;
                }
            }
        }

        // z 자 모양
        for (int i = row; i <= row + 2; i++) {
            for (int j = col + 1; j <= col + 2; j++) {
                int a = 0;
                a += list[i][j] + list[i + 1][j];
                if (list[i][j - 1] + list[i + 1][j + 1] > list[i + 1][j - 1] + list[i][j + 1]) {
                    a += list[i][j - 1] + list[i + 1][j + 1];
                } else {
                    a += list[i + 1][j - 1] + list[i][j + 1];
                }
                if (a > max) {
                    max = a;
                }
            }
        }
    }

    private static void T3(int row, int col) {
        // ㄱ 모양
        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 1; j++) {
                int a = 0;
                a += list[i][j] + list[i][j + 1] + list[i][j + 2];
                a += list[i + 1][j] > list[i + 1][j + 2] ? list[i + 1][j] : list[i + 1][j + 2];
                if (a > max) {
                    max = a;
                }
            }
        }

        // L 모양
        for (int i = row; i <= row + 1; i++) {
            for (int j = col; j <= col + 2; j++) {
                int a = 0;
                a += list[i + 2][j] + list[i + 2][j + 1];
                if (list[i][j] + list[i + 1][j] > list[i][j + 1] + list[i + 1][j + 1]) {
                    a += list[i][j] + list[i + 1][j];
                } else {
                    a += list[i][j + 1] + list[i + 1][j + 1];
                }
                if (a > max) {
                    max = a;
                }
            }
        }

        // L 뒤집은 모양
        for (int i = row; i <= row+1 ; i++) {
            for (int j = col; j <= col+2 ; j++) {
                int a= 0;
                a += list[i][j] + list[i][j + 1];
                if (list[i + 1][j] + list[i + 2][j] > list[i + 1][j + 1] + list[i + 2][j + 1]) {
                    a += list[i + 1][j] + list[i + 2][j];
                } else {
                    a += list[i + 1][j + 1] + list[i + 2][j + 1];
                }
                if (a > max) {
                    max = a;
                }
            }

        }
        //ㄴ 모양
        for (int i = row + 1; i <= row + 3; i++) {
            for (int j = col; j <= col+1; j++) {
                int a = 0;
                a += list[i][j] + list[i][j + 1] + list[i][j + 2];
                if (list[i - 1][j] > list[i - 1][j + 2]) {
                    a += list[i - 1][j];
                } else {
                    a += list[i - 1][j + 2];
                }
                if (a > max) {
                    max = a;
                }
            }
        }
    }

    private static void T2(int row, int col) {
        for (int i = row; i < row + 3; i++) {
            int a = 0;
            for (int j = col; j < col + 3; j++) {
                a = list[i][j] + list[i][j + 1] + list[i + 1][j] + list[i + 1][j + 1];
            }
            if (a > max) {
                max = a;
            }
        }
    }

    private static void T1(int row, int col) {
        for (int i = row; i <= row + 3; i++) {
            int a = 0;
            for (int j = col; j <= col + 3; j++) {
                // ㅡ 자 모양
                a += list[i][j];
            }

            if (a > max) {
                max = a;
            }
        }

        for (int i = col; i <= col + 3; i++) {
            int a = 0;
            for (int j = row; j <= row + 3; j++) {
                // | 자 모양
                a += list[j][i];
            }

            if (a > max) {
                max = a;
            }
        }

    }


}
