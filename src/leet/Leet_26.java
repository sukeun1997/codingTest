package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet_26 {

    public int removeDuplicates(int[] nums) {

        int now = nums[0], answer = 1;
        for (int i = 0; i < nums.length; i++) {
            if (now == nums[i]) {
                continue;
            }
            nums[answer] = nums[i];
            now = nums[i];
            answer++;
        }

        return answer;
    }


    @Test
    void test() {
        Assertions.assertEquals(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}),5);
    }
}
