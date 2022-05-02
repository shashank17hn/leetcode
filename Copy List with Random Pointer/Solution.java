/**
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> keyList = new HashMap<>();
        keyList.put(null,null);
        Node copy = new Node(0,null,null);
        Node copyHead = copy;
        Node current = head;
        while(current!= null){
            keyList.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while(current!= null){
            if(keyList.containsKey(current)){
                copy.next = keyList.get(current);
                copy.next.random = keyList.get(current.random);
                copy = copy.next;
                current = current.next;
            }

        }
        return copyHead.next;

    }
}