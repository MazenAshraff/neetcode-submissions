/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> qOrig = new LinkedList<>();
        Queue<Node> qClone = new LinkedList<>();
        HashMap<Integer,Node> nodesCovered= new HashMap<>();
        Node clone = new Node(node.val);
        qOrig.add(node);
        qClone.add(clone);
        while(!qOrig.isEmpty()){
            Node cur = qOrig.poll();
            Node curClone = qClone.poll();  
            nodesCovered.put(curClone.val, curClone);
            for(Node child: cur.neighbors){
                if(nodesCovered.containsKey(child.val)){
                    curClone.neighbors.add(nodesCovered.get(child.val));
                }
                else{
                    Node newChild = new Node(child.val);
                    curClone.neighbors.add(newChild);
                    qOrig.add(child);
                    qClone.add(newChild);
                    nodesCovered.put(newChild.val,newChild);
                }
            }
        }
        return clone;
    }
}