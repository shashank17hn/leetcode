/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * */

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        int start =0;
        int end =0;
        for(int i =0; i< nums.length; i++){
            if(currSum < 0){
                currSum = 0;
                start = i;
            }
            currSum = currSum + nums[i];

            if(max < currSum){
                max= currSum;
                end = i;
            }

        }
        System.out.println(nums[start] + " " + nums[end]);
        for(int i =start ; i<=end ; i++){
            System.out.println(nums[i]);
        }
        return max;
    }

}