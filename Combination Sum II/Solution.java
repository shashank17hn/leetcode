/**
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 * */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
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
            if(i ==index || candidates[i] != candidates[i-1]){
                current.add(candidates[i]);
                //  System.out.println("current "+ current + " " + target) ;
                helper(i+1,candidates, target -candidates[i], result, current);
                //   System.out.println("current remove "+ current + " " + target) ;
                current.remove(current.size()-1);
            }
        }
    }
}