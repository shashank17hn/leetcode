/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rootList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root== null){
            return rootList;
        }
        List<Integer> parentList = new ArrayList<>();
        parentList.add(root.val);
        rootList.add(parentList);
        queue.add(root);
        int level =1;
        while(queue.size() > 0){
            List<Integer> childList = new ArrayList<>();
            level = queue.size();
            for(int i=0 ; i<level ; i++){
                if(queue.peek().left!= null){
                    childList.add(queue.peek().left.val);
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!= null){
                    childList.add(queue.peek().right.val);
                    queue.add(queue.peek().right);
                }
                queue.poll();
            }
            if(!childList.isEmpty())
                rootList.add(childList);
        }

        return rootList;

    }
}