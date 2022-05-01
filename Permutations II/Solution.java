/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * */

class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new HashSet<>();
        boolean visited[] = new boolean[nums.length];
        helper(nums, 0, visited , new ArrayList<Integer>());
        return new ArrayList<>(result);
    }

    private void helper(int nums[], int index , boolean visited[] , List<Integer> list){

        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }

        for(int i=0; i<nums.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                helper(nums, i+1, visited, list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }

    }
}