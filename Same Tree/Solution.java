/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }
        if(p==null || q== null){
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else
            return false;


    }
}


//recursive
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if(p == null && q== null){
//             return true;
//         }


//         Stack<TreeNode> tree1 = new Stack<>();
//         Stack<TreeNode> tree2 = new Stack<>();
//         tree1.push(p);
//         tree2.push(q);
//         while(!tree1.empty() && !tree2.empty()){

//             TreeNode temp1 = tree1.pop();
//             TreeNode temp2 = tree2.pop();
//             // System.out.println("temp1 "+ temp1.val);
//             // System.out.println("temp2 "+ temp2.val);
//             if(temp1 == null || temp2 == null){
//                       return false;
//             }
//             if(temp1.val != temp2.val){
//                 return false;
//             }
//             if(temp1.left!= null && temp2.left!= null){
//                  tree1.push(temp1.left);
//                  tree2.push(temp2.left);
//             }else if(temp1.left!= null || temp2.left!= null){
//                      return false;
//             }
//             if(temp1.right!= null && temp2.right!= null){
//                  tree1.push(temp1.right);
//                  tree2.push(temp2.right);
//             }else if(temp1.right!= null || temp2.right!= null){
//                 return false;
//             }

//         }
//         return true;

//     }
// }