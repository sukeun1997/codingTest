package programmers.level2;

import java.util.Arrays;

public class level2_7 {

    static int count = 0;
    public static int solution(int[] numbers, int target) {

        find(0,numbers,target,0);
        return count;
    }

    private static void find(int i, int[] numbers, int target,int result) {

        if (i == numbers.length) {
            if (result == target) {
                count++;
            }
            return;
        }
                find(i + 1, numbers, target,result + numbers[i]);
                find(i + 1, numbers, target, result - numbers[i]);
    }

    public static void main(String[] args) {

        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
