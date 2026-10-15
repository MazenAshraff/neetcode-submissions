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
    public ListNode mergeKLists(ListNode[] lists) {
        int completedCount = 0;
        int k = lists.length;
        for(int i = 0;i < k;i++){
            if(lists[i] == null) completedCount++;
        }
        ListNode dummy = new ListNode(1000);
        ListNode cur = dummy;
        while(completedCount != k){
            ListNode min = null;
            int minIndex = -1;
            for(int i = 0; i < k; i++){
                if(lists[i] == null) continue;
                if(min == null){
                    min = lists[i];
                    minIndex = i;
                }
                else{
                    if(lists[i].val < min.val){
                        min = lists[i];
                        minIndex = i;
                    }
                }
            }
            if(min!=null){
                cur.next = min;
                cur = cur.next;
                lists[minIndex] = lists[minIndex].next;
                if(lists[minIndex] == null){
                    completedCount++;
                } 
            }
        }
        return dummy.next;
    }
}
