/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
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

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // inorderTraversalUtils(root);
        inorderIterative(root);
        return list;
    }

    //recursive
    public void inorderTraversalUtils(TreeNode root) {
        if(root == null){
            return;
        }
        inorderTraversalUtils(root.left);
        list.add(root.val);
        inorderTraversalUtils(root.right);
    }

    //iterative
    private void inorderIterative(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.empty()) break;
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }

        }

    }

}