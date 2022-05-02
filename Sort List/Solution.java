/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next== null){
            return head;
        }

        ListNode left = head;
        ListNode right = getCenterNode(head);
        ListNode temp = right.next;
        right.next = null;
        right= temp;

        left = sortList(left);
        right = sortList(right);

        return mergeList(left, right);

    }


    private ListNode mergeList(ListNode node1 , ListNode node2){
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(node1!= null && node2!=null){
            if(node1.val < node2.val){
                current.next = node1;
                node1 = node1.next;
            }else{
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        if(node1!= null){
            current.next = node1;
        }
        if(node2!= null){
            current.next = node2;
        }
        return dummy.next;
    }

    private ListNode getCenterNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}