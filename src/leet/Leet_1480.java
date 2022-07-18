package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Running Sum of 1d Array
 */
public class Leet_1480 {

    public int[] runningSum(int[] nums) {

        List<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            list.add(sum);
        }

        return list.stream().mapToInt(value -> value).toArray();

    }
}
