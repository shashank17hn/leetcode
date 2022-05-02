/**
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
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
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // find middle -> slow is middle
        while(fast!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = slow;
        ListNode prev = null;
        // revese second half;
        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second.next!= null){
            ListNode temp = first.next;
            ListNode tem2 = second.next;

            first.next = second;
            first = first.next;

            first.next = temp;
            first = first.next;

            second = tem2;

        }


    }
}