/**
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size =0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            size++;
        }

        current = head;
        int index =0;
        System.out.println(size + " " + (size-1-n));
        while(index<size-1-n && current!= null){
            current = current.next;
            index++;
        }
        System.out.println(current.val);
        if(size-n==0) return current.next;
        if(current!= null && current.next!= null){
            current.next = current.next.next;

        }
        return head;
    }
}