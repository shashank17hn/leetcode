/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        int index =0;
        ListNode current = head;
        while(current!= null && index<k-1){
            current = current.next;
            index++;
        }
        if(current!= null){
            ListNode next = current.next;
            current.next = null;

            head = reverse(head);
            current = head;

            while(current.next!=null){
                current = current.next;
            }
            current.next =reverseKGroup(next, k);
        }
        return head;

    }

    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        while(current!= null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}