/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
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
 preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 ){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for(int i =0; i< inorder.length ; i++){
            if(inorder[i]==preorder[0]){
                index =i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1, index+1),Arrays.copyOfRange(inorder,0,index));

        root.right = buildTree(Arrays.copyOfRange(preorder,index+1, preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }

}