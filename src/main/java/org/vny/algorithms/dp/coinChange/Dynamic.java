package org.vny.algorithms.dp.coinChange;

import java.util.Arrays;

public class Dynamic implements Main {

  @Override
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 0; i < dp.length; i++) {
      for (int coin : coins) {
        if (i - coin < 0) continue;
        dp[i] = Integer.min(dp[i], 1 + dp[i - coin]);
      }
    }
    return (dp[amount] == amount + 1) ? -1 : dp[amount];
  }
}