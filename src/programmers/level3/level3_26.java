package programmers.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class level3_26 {

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);



        int r = 0;

        for (int i = 0; i < A.length; i++) {

            if (r == B.length) {
                break;
            }
            for (int j = r; j < B.length; j++) {

                if (A[i] < B[j]) {
                    answer++;
                    r = j + 1;
                    break;
                }
                r++;
            }
        }


        return answer;
    }

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}),3);
        Assertions.assertEquals(solution(new int[]{2,2,2,2}, new int[]{1,1,1,1}),0);
    }
}
