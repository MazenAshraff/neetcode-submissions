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
    HashMap<Integer,Node> nodes = new HashMap<>();
    Node resultNode = new Node();
    Queue<Node> q =  new LinkedList<Node>();
    Queue<Node> newq =  new LinkedList<Node>();
    Node curNode = resultNode;
    newq.add(curNode);
    q.add(node);
    while(!q.isEmpty()){
        Node toCopy = q.poll();
        Node newNode = newq.poll();
        nodes.put(toCopy.val, newNode);

        newNode.val = toCopy.val;
        for(Node adj : toCopy.neighbors){

            if(!nodes.containsKey(adj.val)){
            Node toBeAdded = new Node(adj.val);
            nodes.put(adj.val,toBeAdded);
            newNode.neighbors.add(toBeAdded);    
            q.add(adj);
            newq.add(toBeAdded);
            }
            else{
                newNode.neighbors.add(nodes.get(adj.val));
            }
        }
    }
    return resultNode;
    }
}
