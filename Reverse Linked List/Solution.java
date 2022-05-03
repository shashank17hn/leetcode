/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
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
// iterative
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode current = head;
        ListNode previous = null;
        while(current!= null){
            ListNode newNext = current.next;
            current.next = previous;
            previous = current;
            current = newNext;
        }
        return previous;
    }

// recursive
//     public ListNode reverseList(ListNode head) {
//         if(head == null)
//             return head;
//         head = reverseLinkedList(head);
//         return head;
//     }

//     private ListNode reverseLinkedList(ListNode node){
//         if(node.next == null){
//             ListNode newHead = node;
//             return newHead;
//         }

    // ListNode newHead = reverseLinkedList(node.next);
    // node.next.next = node;
    // node.next = null;
    // return newHead;

//     }
}