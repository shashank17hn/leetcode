/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        // recursive call
        // postOrder(root);
        // iterative call
        postOrderIterative(root);
        return list;

    }
    // recursive
    private void postOrder(TreeNode root){
        if(root == null) return;
        if(root.left!= null) postOrder(root.left);
        if(root.right!= null) postOrder(root.right);
        list.add(root.val);
    }

    //iterative
    private void postOrderIterative(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if(node.left!= null){
                stack.push(node.left);
            }
            if(node.right!= null){
                stack.push(node.right);
            }
            ans.push(node.val);
        }

        while(!ans.isEmpty()){
            list.add(ans.pop());
        }
    }

}