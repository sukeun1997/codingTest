package programmers;

import java.util.Arrays;
// 프로그래머스

public class level1_2 {
    public static int solution(int[][] sizes) {
        int x = 0;
        int y = 0;


        for (int[] size : sizes) {
            if (Arrays.stream(size).max().getAsInt() > x) {
                x = Arrays.stream(size).max().getAsInt();
            }
            if (Arrays.stream(size).min().getAsInt() > y) {
                y = Arrays.stream(size).min().getAsInt();
            }
        }
        int answer = x*y;
        return answer;
    }

    public static void main(String[] args) {
        int[][] size = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        solution(size);
    }
}
