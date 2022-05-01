/**
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * */

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums!= null && nums.length ==0){
            return 1;
        }

        boolean contains1 = false;

        //-1 && 0 to 1
        for(int i=0 ; i< nums.length ; i++){
            if(nums[i] == 1){
                contains1 =true;
            }
            else if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }

        if(!contains1){
            return 1;
        }

        // make negative
        for(int i =0 ; i< nums.length ; i++){
            int temp =  Math.abs(nums[i])-1;
            if(nums[temp] >0){
                nums[temp] = -1 * nums[temp];
            }
        }

        int index = -1;
        for(int i=0 ; i< nums.length ; i++){
            if(nums[i] >0){
                return i+1;
            }
        }

        return nums.length+1;

    }
}