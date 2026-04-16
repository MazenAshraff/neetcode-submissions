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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow !=null && fast !=null ){
            slow = slow.next;
            if(fast.next!= null){
                fast = fast.next.next;
            }
            else{
                return false;
            }
            if(slow == fast) return true;
        }
        return false;
    }
}
