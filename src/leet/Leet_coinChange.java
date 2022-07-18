package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Leet_coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        if (amount == 0) {
            return 0;
        }

        for (int coin : coins) {
            if(coin > amount)
                continue;
            dp[coin] = 1;
        }

        for (int i = 1; i <= amount ; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                continue;
            }
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] > 0 && dp[i-coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[coins[j]] + dp[i - coins[j]]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    @Test
    void test() {
        Assertions.assertEquals(coinChange(new int[]{1,2,5},11),3);
        Assertions.assertEquals(coinChange(new int[]{2},3),-1);
        Assertions.assertEquals(coinChange(new int[]{1},0),0);
    }
}
