package baekjoon;

import java.io.*;
import java.util.ArrayList;

/**
 * 스도쿠
 */
public class Main_2580 {

    static int zeroCount = 0;
    static ArrayList<int[]> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int map[][];
        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 0) {
                    list.add(new int[]{i, j});
                    zeroCount++;
                }
            }
        }

        find(map,0);
    }

    private static void find(int map[][],int idx) throws IOException {
        if (idx == zeroCount) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(map[i][j] +" ");
                }
                bw.write("\n");
            }

            bw.flush();
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int[] number = list.get(idx);
            if (can(map,number,i)) {
                map[number[0]][number[1]] = i;
                find(map,idx+1);
                map[number[0]][number[1]] = 0;
            }
        }
    }

    private static boolean can(int map[][], int[] numbers, int i) {

        for (int j = 0; j < 9; j++) {
            if (map[j][numbers[1]] == i) {
                return false;
            }

            if (map[numbers[0]][j] == i) {
                return false;
            }
        }

        int x = numbers[0];
        int y = numbers[1];

        int t = findLocation(x);
        int z = findLocation(y);

        for (int j = t-3; j < t; j++) {
            for (int k = z-3; k < z; k++) {
                if (map[j][k] == i) {
                    return false;
                }
            }
        }



        return true;
    }

    private static int findLocation(int x) {
        int t = 0;
        if(x < 3) {
            t = 3;
        } else if (x < 6) {
            t = 6;
        } else {
            t = 9;
        }
        return t;
    }
}
