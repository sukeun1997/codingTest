package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leet_41 {

/*    public int firstMissingPositive(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, 1);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!hashMap.containsKey(i)) {
                return i;
            }
        }

        return 0;
    }*/

    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    @Test
    void test() {
//        Assertions.assertEquals(firstMissingPositive(new int[]{7,8,9,11,12}), 1);
//        Assertions.assertEquals(firstMissingPositive(new int[]{3,4,-1,1}), 2);
        Assertions.assertEquals(firstMissingPositive(new int[]{1,2,0}), 3);
    }
}
