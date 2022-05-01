/**
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * */

class Solution {
    public int jump(int[] nums) {
        int farthest =0;
        int end=0;
        int jump = 0;
        for(int i =0 ; i<nums.length-1 ; i++){

            farthest = Math.max(farthest, i+ nums[i]);

            if(i == end){
                jump++;
                end = farthest;
            }
        }
        return jump;

    }
}