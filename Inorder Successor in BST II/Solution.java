/**
 * Given a node in a binary search tree, return the in-order successor of that node in the BST. If that node has no in-order successor, return null.
 *
 * The successor of a node is the node with the smallest key greater than node.val.
 *
 * You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. Below is the definition for Node:
 *
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node parent;
 * }
 *
 *
 * Input: tree = [2,1,3], node = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both the node and the return value is of Node type.
 *
 * Input: tree = [5,3,6,2,4,null,null,1], node = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 *
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        Node current = node;
        if(current!= null && current.right!= null){
            current = current.right;
            while(current.left!= null){
                current = current.left;
            }
            return current;
        }else{
            while(current.parent!= null && current.parent.right == current) {
                current = current.parent;
            }
            return current.parent;
        }
    }
}