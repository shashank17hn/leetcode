/**
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// recursive solution

 class Solution {
     public ListNode swapPairs(ListNode head) {
        if(head== null || head.next== null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = second.next;
        second.next = first;
        first.next = swapPairs(first.next);

        return second;

     }
 }

// iterative solution

//class Solution {
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        ListNode prev = dummy;
//        while(head!= null && head.next!= null){
//
//            ListNode first = head;
//            ListNode second = head.next;
//
//            prev.next = second;
//            first.next = second.next;
//            second.next = first;
//
//            prev =first;
//            head= first.next;
//
//        }
//
//        return dummy.next;
//
//    }
//}


