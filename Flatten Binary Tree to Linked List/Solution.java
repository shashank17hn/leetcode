/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [0]
 * Output: [0]
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
    List<TreeNode> list;
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        if(left!= null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return right == null? left :right;

    }


// bt using traversal approach
//     public void flatten(TreeNode root) {
//         list = new ArrayList<>();
//         preOrderTraversal(root);
//       for(int i =0 ; i<list.size()-1 ; i++){

//          TreeNode node1 = list.get(i);
//          TreeNode node2 = list.get(i+1);
//       //  System.out.println(node1.val + " " + node2.val);
//          node1.left = null;
//          node1.right = node2;
//       }
//     }

//    private void preOrderTraversal(TreeNode root){
//        if(root == null) return;
//
//        list.add(root);
//        if(root.left!= null){
//            preOrderTraversal(root.left);
//        }
//        if(root.right!= null){
//            preOrderTraversal(root.right);
//        }
//    }
}