/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        helper(1,n,k,new ArrayList<>());
        return result;
    }

    private void helper(int index , int n , int k , List<Integer> list){

        if(list.size()==k){
            System.out.println("added" + list);
            result.add(new ArrayList<>(list));
        }

        for(int i=index ; i<=n ; i++){
            list.add(i);
            System.out.println(list);
            helper(i+1,n,k,list);
            list.remove(list.size()-1);
            System.out.println(list);
        }
    }
}