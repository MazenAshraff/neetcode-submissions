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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        ListNode cur = head;
        ListNode par = null;
        while(fast!=null){
            par = cur;
            cur = cur.next;
            fast = fast.next;
        }
        if(par == null) return head.next;
        par.next = cur.next;
        return head;
    }
}
