/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node copy = new Node(head.val);
        HashMap<Node, Node> hm = new HashMap<>();
        hm.put(head, copy);
        Node cur = head;
        Node curCopy = copy;
        while(cur != null){
            curCopy.val = cur.val;
            if(hm.containsKey(cur.random)){
                curCopy.random = hm.get(cur.random);
            }
            hm.put(cur, curCopy);
            if(cur.next!=null){
                curCopy.next = new Node(-1);
            }
            curCopy = curCopy.next;
            cur = cur.next;
        }

        cur = head;
        curCopy = copy;
        while(cur!= null){
            curCopy.random = hm.get(cur.random);
            curCopy = curCopy.next;
            cur = cur.next;
        }



        return copy;
    }
}
