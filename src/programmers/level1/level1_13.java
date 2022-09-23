package programmers.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class level1_13 {


    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};

        int[][] map = new int[n][n];

        for (int i = 0; i < arr1.length; i++) {

            int num = n - 1;
            while (arr1[i] >= 1) {
                map[i][num--] = arr1[i] % 2;
                arr1[i] /= 2;
            }

            num = n - 1;
            while (arr2[i] >= 1) {
                map[i][num--] += arr2[i] % 2;
                arr2[i] /= 2;
            }
        }

        String[] strings = Arrays.stream(map).map(ints -> Arrays.stream(ints).mapToObj(value -> {
            if (value == 2 || value == 1) {
                return "#";
            } else {
                return " ";
            }
        }).collect(Collectors.joining())).toArray(String[]::new);


        return strings;
    }

    @Test
    void test() {
        Assertions.assertArrayEquals(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}), new String[]{"#####", "# # #", "### #", "# ##", "#####"});
    }
}
