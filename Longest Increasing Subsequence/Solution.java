/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * */

class Solution {
    public int lengthOfLIS(int[] nums) {

        //Input: nums = [10,9,2,5,3,7,101,18]

        int lookup[] = new int[nums.length];
        int max = Integer.MIN_VALUE;
        Arrays.fill(lookup, 1);

        for(int i =1 ; i< nums.length ; i++){
            for(int j=0; j< i; j++){
                if(nums[i] > nums[j]){
                    lookup[i] = Math.max(lookup[i], lookup[j]+1);
                }
            }
        }

        for(int i =0 ; i< lookup.length ; i++){
            if(max< lookup[i]){
                max = lookup[i];
            }
        }
        return max;
    }
}