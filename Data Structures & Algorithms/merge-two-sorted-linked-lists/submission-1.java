/**
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
        ListNode list3 = new ListNode(-1000);
        ListNode endOfList3 = list3;
        while(list1 != null || list2!= null){
            if(list1 != null && list2 != null){
                if(list1.val < list2.val){
                        endOfList3.next = list1;
                        list1 = list1.next;
                        endOfList3 = endOfList3.next;
                    }
                else{
                        endOfList3.next = list2;
                        list2 = list2.next;
                        endOfList3 = endOfList3.next;
                }
                }
            else{
                if(list1 == null){
                    endOfList3.next = list2;

                }
                else{
                    endOfList3.next = list1;
                }
                break;
            }
        }
        return list3.next;
    }
}