/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> rootList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if(root== null){
            return rootList;
        }
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> childList = new ArrayList<>();
            while(!stack1.isEmpty()){
                TreeNode temp = stack1.pop();
                if(temp.left!= null){
                    stack2.push(temp.left);
                }
                if(temp.right!= null){
                    stack2.push(temp.right);
                }
                childList.add(temp.val);
            }

            if(childList.size()> 0)
                rootList.add(new ArrayList<>(childList));
            childList.clear();
            while(!stack2.isEmpty()){
                TreeNode temp = stack2.pop();
                if(temp.right!= null){
                    stack1.push(temp.right);
                }
                if(temp.left!= null){
                    stack1.push(temp.left);
                }

                childList.add(temp.val);
            }
            if(childList.size()> 0)
                rootList.add(new ArrayList<>(childList));

        }


        return rootList;

    }
}