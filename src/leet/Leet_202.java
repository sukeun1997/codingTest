package leet;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number
 */
public class Leet_202 {

    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int sum = 0;

            while (n != 0) {
                int n1 = n % 10;
                n = n / 10;
                sum += Math.pow(n1, 2);
            }

            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }

        return false;
    }

    @Test
    void tset() {

        System.out.println(isHappy(19));
    }
}
