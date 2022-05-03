/**
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 *
 * Input: root = [3,9,8,4,0,1,7]
 * Output: [[4],[9],[3,0,1],[8],[7]]
 *
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<int[]>> map = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        dfs(root,0,0);
        List< List<Integer>> result = new ArrayList<>();
        for(List<int[]> val : map.values()){
            List<Integer> list = new ArrayList<>();
            val.sort((a,b)-> a[0]-b[0]);
            for(int arr[] :val){
                list.add(arr[1]);
            }
            result.add(list);
        }
        return result;
    }

    private void dfs(TreeNode root, int index, int col){
        if(root== null) return;
        if(!map.containsKey(index)){
            List<int[]> list = new ArrayList<>();
            map.put(index, list);
        }
        map.get(index).add(new int[]{col,root.val});
        if(root.left!= null){
            dfs(root.left , index-1, col+1);
        }
        if(root.right!= null){
            dfs(root.right , index+1, col+1);
        }
    }
}