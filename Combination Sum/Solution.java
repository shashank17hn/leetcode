/**
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 * **/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        helper(0,candidates, target,result,  new ArrayList<Integer>());
        return result;

    }

    private void helper(int index, int candidates[], int target , List<List<Integer>> result , List<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i =index; i < candidates.length ; i++){
            current.add(candidates[i]);
            System.out.println("current "+ current + " " + target) ;
            helper(i,candidates, target -candidates[i], result, current);
            System.out.println("current remove "+ current + " " + target) ;
            current.remove(current.size()-1);

        }
    }


}