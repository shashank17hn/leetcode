/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
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
    List<Integer> list;
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        //preOrder(root);
        preOrderIterative(root);
        return list;
    }

    // recursive
    private void preOrder(TreeNode root){
        if(root == null) return;
        list.add(root.val);
        if(root.left!= null) preOrder(root.left);
        if(root.right!= null) preOrder(root.right);

    }

    //iterative
    private void preOrderIterative(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!= null){
                stack.push(node.right);
            }
            if(node.left!= null){
                stack.push(node.left);
            }

        }

    }



}