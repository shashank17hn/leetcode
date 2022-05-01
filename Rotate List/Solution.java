/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
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
    public ListNode rotateRight(ListNode head, int k) {

        if(head ==null) return null;

        ListNode tail = head;
        int i;

        for(i=1; tail.next!= null ; i++){
            tail = tail.next;
        }
        tail.next = head;

        ListNode newtail = head;
        for(int j=0 ; j< i-k%i-1 ;j++){

            newtail = newtail.next;
        }

        ListNode newhead = newtail.next;
        newtail.next  = null;
        return newhead;

    }
}