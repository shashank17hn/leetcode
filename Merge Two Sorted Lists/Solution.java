/**
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 ==null && list2 == null){
            return list1;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        int temp= 0;
        while(list1!=null || list2!=null){
            if(list1!= null && list2!=null){
                if(list1.val<list2.val){
                    temp = list1.val;
                    list1 = list1.next;
                }else{
                    temp= list2.val;
                    list2 = list2.next;
                }
            }else if(list1!= null){
                temp = list1.val;
                list1 = list1.next;
            }else if(list2!= null){
                temp = list2.val;
                list2 = list2.next;
            }
            result.next = new ListNode(temp);
            result= result.next;
        }
        return head.next;

    }
}