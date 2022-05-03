/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * */

class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return helper(coins,amount);
    }

    private int helper(int[] coins, int amount){

        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(cache.containsKey(amount)) return cache.get(amount);
        int min = Integer.MAX_VALUE;
        int res=0;
        for(int coin : coins){
            res =  helper(coins, amount-coin);
            if(res>=0 && res<min){
                min = res+1;
            }

        }
        if(min == Integer.MAX_VALUE){
            cache.put(amount, -1);
        }else{
            cache.put(amount, min);
        }

        // System.out.println(cache);
        return cache.get(amount);
    }


    // dynamic programming
    //     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount+1];
//         Arrays.fill(dp, amount+1);
//         dp[0]=0;

//         for(int a= 1; a<= amount; a++){

//             for(int c=0 ; c< coins.length ; c++){

//                 if(a-coins[c]>=0){
//                     dp[a] = Math.min(dp[a], 1+dp[a-coins[c]]);
//                 }

//             }

//         }

//         if(dp[amount] == amount+1){
//             return -1;
//         }else  {
//             return dp[amount];
//         }


//     }





}