/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 * */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result.add(list);
        helper(0, nums,list);
        return result;
    }

    private void helper(int index , int[] nums, List<Integer> list){
        if(index>= nums.length){
            return;
        }

        for(int i = index; i<nums.length ; i++){
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            helper(i+1, nums, list);
            list.remove(list.size()-1);
        }

    }
}