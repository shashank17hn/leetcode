/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 **/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int result[] = new int[]{-1,-1};
        int first = search(true,target,nums);
        if(first == -1) return result;
        int last =  search(false,target,nums);
        result[0] = first;
        result[1] = last;

        return result;
    }

    private int search(boolean isFirst, int target ,int nums[]){
        int left = 0;
        int right = nums.length-1;
        int mid =0;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid] == target){
                if(isFirst){
                    if(mid-1 < 0 || nums[mid-1] !=target) return mid;
                    right=mid-1;
                }else{
                    if(mid+1 >=nums.length || nums[mid+1] !=target) return mid;
                    left=mid+1;
                }
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right =mid-1;
            }

        }
        return -1;

    }

}