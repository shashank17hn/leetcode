/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 * */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        // List<Integer> current = new ArrayList<>();
        helper(1,k,9, n,result,  new ArrayList<Integer>());
        return result;

    }

    private void helper(int index, int size, int candidates, int target , List<List<Integer>> result , List<Integer> current){
        if(target == 0 && current.size() == size){
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0){
            return;
        }



        for(int i =index; i <= candidates ; i++){
            if(current.size()< size) {
                current.add(i);
                System.out.println("current "+ current + " " + target) ;
                helper(i+1,size,candidates, target -i, result, current);
                System.out.println("current remove "+ current + " " + target) ;
                current.remove(current.size()-1);
            }
        }
    }
}