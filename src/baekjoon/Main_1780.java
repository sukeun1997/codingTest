package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1780 {
    static int n;
    static int paper[][];
    static Map<Integer, Integer> number = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        paper = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int l = 0; l < n; l++) {
                paper[i][l] = sc.nextInt();
            }
        }
        for (int i = -1; i < 2; i++)
            number.put(i, 0);

        paperCount(0, 0, n);

        for (int ns : number.values()) {
            System.out.println(ns);
        }

    }

    public static void paperCount(int row, int col, int size) {
        if (size < 1) {
            return;
        }
        boolean isAll = true;
        int previousN = -2;

        for (int i = row; i < row + size; i++) {
            for (int l = col; l < col + size; l++) {
                if (previousN == -2) {
                    previousN = paper[i][l];
                } else if (previousN != paper[i][l]) {
                    isAll = false;
                    break;
                }
            }
            if (!isAll) {
                break;
            }
        }

        if (!isAll) {
            size /= 3;
            for (int i = 0; i <= 2; i++) {
                for (int l = 0; l <= 2; l++) {
                    paperCount(row + (i*size),col + (l*size),size);
                }
            }
        } else {
            number.put(previousN, number.get(previousN) + 1);
        }
    }


}
