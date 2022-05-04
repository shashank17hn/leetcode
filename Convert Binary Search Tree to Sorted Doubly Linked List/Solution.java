/**
 * Input: root = [4,2,5,1,3]
 * Output: [1,2,3,4,5]
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 *
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 *
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    List<Integer> list = new ArrayList<>();
    Node head = null;
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        traverse(root);
        if(head== null) return null;
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void traverse(Node root){
        if(root ==null) return;

        if(root.left!=null){
            traverse(root.left);
        }

        if(head == null){
            head = root;
        }else{
            prev.right = root;
            root.left = prev;
        }

        prev = root;
        if(root.right!=null){
            traverse(root.right);
        }
    }


}