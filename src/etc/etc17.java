package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 무지의 먹방 라이브
 */
public class etc17 {
    public int solution(int[] food_times, long k) {


        int start =0;

        while (k > 0) {
            k--;
            if (start >= food_times.length) {
                start =0;
            }
            food_times[start]--;
            start++;
        }
        return start+1;
    }


    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{3,1,2},5),1);
    }

}
