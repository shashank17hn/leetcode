/**
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], m = 2
 * Output: 9
 * Example 3:
 *
 * Input: nums = [1,4,4], m = 3
 * Output: 4
 * */
class Solution {
    public int splitArray(int[] nums, int m) {

        int max = Arrays.stream(nums).max().getAsInt();
        int sum = Arrays.stream(nums).sum();

        int left = max;
        int right = sum;
        int result = sum;

        while(left<=right){
            int mid = left +((right-left)/2);
            if(canSplit(nums,mid ,m)){
                result = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return result;
    }

    private boolean canSplit(int nums[], int mid, int m){
        int sub = 1;
        int total = 0;
        for(int i=0 ; i<nums.length ; i++){
            total += nums[i];
            if(total>mid){
                sub++;
                total = nums[i];
            }
        }

        return sub<=m ? true : false;

    }
}