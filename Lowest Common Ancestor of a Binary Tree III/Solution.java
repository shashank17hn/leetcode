/**
 *
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 *
 * Each node will have a reference to its parent node. The definition for Node is below:
 *
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node parent;
 * }
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
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
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p;
        Node p2 = q;
        while(p1!=p2){
            p1 = p1.parent ==null ? q : p1.parent;
            p2=  p2.parent == null ? p : p2.parent;
        }
        return p1;
    }

    // uses extra space
//     public Node lowestCommonAncestor(Node p, Node q) {
//       Set<Node> set = new HashSet<>();
//         while(p!= null){
//             set.add(p);
//             p = p.parent;
//         }

//         while(q!=null){
//             if(set.contains(q)) return q;
//             q = q.parent;
//         }
//         return null;
//     }
}