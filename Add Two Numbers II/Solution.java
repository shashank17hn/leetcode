/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * Example 2:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * Example 3:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 =  reverseList(l1);
        ListNode reverseL2 =  reverseList(l2);
        ListNode result = null;
        int sum =0;
        int carry =0;
        while(reverseL1 != null || reverseL2!= null){
            if(reverseL1 != null && reverseL2!= null){
                sum = reverseL1.val + reverseL2.val +carry;
                reverseL1 = reverseL1.next;
                reverseL2 = reverseL2.next;
            }else if(reverseL1 != null){
                sum = reverseL1.val +carry;
                reverseL1 = reverseL1.next;
            }else if(reverseL2 != null){
                sum = reverseL2.val +carry;
                reverseL2 = reverseL2.next;
            }
            carry = sum/10;
            sum = sum%10;

            if(result== null){
                result =  new ListNode(sum);
            }else {
                ListNode temp = result;
                result = new ListNode(sum);
                result.next = temp;
            }
        }
        if(carry > 0 ){
            if(result== null){
                result =  new ListNode(carry);
            }else {
                ListNode temp = result;
                result = new ListNode(carry);
                result.next = temp;
            }
        }
        return result;
    }

    public ListNode reverseList(ListNode node){
        ListNode current = node;
        ListNode previous = null;
        while(current!= null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}