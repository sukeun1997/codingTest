package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;

/**
 * N-Queen
 */
public class Main_9663_2 {

    static int n;
    static int queen[];
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        queen = new int[n];

        find(0);
        System.out.println(count);

    }

    /**
     *
     * @param idx => col
     */
    private static void find(int idx) {

        if (idx == n) {
            count++;
            return;
        }


        for (int i = 0; i < n; i++) {
            queen[idx] = i;
            if (canPlace(idx)) {
                find(idx + 1);
            }
        }



    }

    /**
     * 배치 가능한지 확인
     */
    private static boolean canPlace(int col) {

        for (int i = 0; i < col; i++) {

            // 같은 행에 있는지
            if (queen[i] == queen[col]) {
                return false;

            // 대각선 확인
            } else if(Math.abs(i-col) == Math.abs(queen[i]-queen[col])) {
                return false;
            }
        }

        return true;
    }
}
