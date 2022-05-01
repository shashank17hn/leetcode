/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 * */

class Solution {

    Set<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        result.add(list);
        helper(0, nums,list);
        List<List<Integer>> ans = new ArrayList<>(result);
        return ans;
    }

    private void helper(int index , int[] nums, List<Integer> list){
        if(index>= nums.length){
            return;
        }

        for(int i = index; i<nums.length ; i++){
            System.out.println("current "+ list ) ;
            if(i!= index && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            helper(i+1, nums, list);
            list.remove(list.size()-1);
            System.out.println("current remove"+ list ) ;
        }

    }
}