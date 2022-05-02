/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {

        return isValidBSTUtils(root, null , null);
        // return isBSTByInorderTraversal(root);

    }

    public boolean isValidBSTUtils(TreeNode node, Integer max , Integer min){
        if(node == null){
            return true;
        }
        else if((max != null &&node.val>=max)|| (min!= null && node.val <= min)){
            return false;
        }
        return isValidBSTUtils(node.left, node.val, min)  && isValidBSTUtils(node.right, max, node.val);

    }

//       public boolean isBSTByInorderTraversal(TreeNode node){
//         if(node == null){
//             return true;
//         }
//         if(!isBSTByInorderTraversal(node.left)){
//             return false;
//         }
//         if(prev!= null && node.val <= prev){

//             return false;
//         }
//         prev = node.val;
//         return isBSTByInorderTraversal(node.right);
//     }
}