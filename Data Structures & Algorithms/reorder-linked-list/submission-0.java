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
    public void reorderList(ListNode head) {
      LinkedList<ListNode> ls = new LinkedList<>();
      ListNode cur = head;
      while(cur != null){
        ls.add(cur);
        cur = cur.next;
      }
      int i = 1;
      ListNode result = ls.removeFirst();
      cur = result;
      while(!ls.isEmpty()){
        if(i%2 == 0){
            cur.next = ls.removeFirst();
        }
        else{
            cur.next = ls.removeLast();

        }
            cur = cur.next;
            i++;
      }
      cur.next = null;
    }
}
