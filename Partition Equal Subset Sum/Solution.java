/**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * */
class Solution {
    Map<String , Boolean> cache;
    public boolean canPartition(int[] nums) {
        cache = new HashMap<>();
        int sum = 0;
        for(int i =0 ; i<nums.length ; i++){
            sum += nums[i];
        }
        if(sum%2 !=0) return false;

        for(int i=0 ; i<nums.length ; i++){
            if(helper(i,nums,sum/2)) return true;
        }
        return false;
    }

    private boolean helper(int i , int nums[] , int sum){
        String key = sum+","+i;
        if(cache.containsKey(key)) return cache.get(key);
        if(sum ==0){
            return true;
        }
        if(sum<0 || i>=nums.length || i<0){
            return false;
        }
        boolean res = helper(i+1, nums, sum) || helper(i+1, nums, sum-nums[i]);
        cache.put(key, res);
        return res;
    }


}

// dynamic programming
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for(int i =0 ; i<nums.length ; i++){
//             sum += nums[i];
//         }
//         if(sum%2 !=0) return false;

//         boolean[][] dp= new boolean[nums.length+1][sum+1];

//         for(int i =0 ; i<dp.length ; i++){
//             dp[i][0] = true;
//         }

//         for(int i=1 ; i< dp.length ; i++){
//             for(int j =1 ; j<dp[0].length ; j++){
//                 if(j< nums[i-1]){
//                     dp[i][j] = dp[i-1][j];
//                 }else{
//                      dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
//                 }
//             }
//         }
//         return dp[nums.length][sum];
//     }


// }