/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 * */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0 ; i< nums.length ; i++){
            if(i ==0 || nums[i]!= nums[i-1]){
                int low = i+1;
                int high = nums.length-1;
                int sum = 0-nums[i];
                while(low<high){
                    if( sum == nums[low] + nums[high]){
                        result.add(new ArrayList(Arrays.asList(nums[i], nums[low], nums[high])));
                        while(low< high && nums[low] == nums[low+1]){
                            low++;
                        }
                        while(low< high && nums[high] == nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;

                    }else if(sum > nums[low] + nums[high]){
                        low++;
                    }else {
                        high--;
                    }
                }
            }
        }
        return result;



    }
}