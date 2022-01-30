package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 타겟 넘버
 */
public class level2_22 {


    static int count = 0;
    public int solution(int[] numbers, int target) {


        dfs(numbers, target, 0, 0);



        return count;
    }

    private void dfs(int[] numbers, int target, int depth, int now) {

        if (depth == numbers.length) {
            if (now == target) {
                count++;
            }
            return;
        }


        dfs(numbers,target,depth+1,now+numbers[depth]);
        dfs(numbers,target,depth+1,now-numbers[depth]);

    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{1,1,1,1,1},3),5);
        Assertions.assertEquals(solution(new int[]{4, 1, 2, 1},4),2);
    }
}
