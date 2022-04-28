/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i =0 ; i< nums.length ; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int total = nums[left]+nums[right]+nums[i];
                if(Math.abs(diff)> Math.abs(target-total)){
                    System.out.println("target-total "+ (target-total) + " " +diff);
                    diff = target-total;
                }
                if(total>target){
                    right--;
                }
                else{
                    left++;
                }

            }
        }
        return target-diff;

    }
}