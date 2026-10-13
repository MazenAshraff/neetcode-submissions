class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Node> hm = new HashMap<>();
        int max = 0;
        for(int i = 0;i < nums.length; i++){
            if(!hm.containsKey(nums[i])){
                Node before = hm.get(nums[i] - 1);
                Node after = hm.get(nums[i] + 1);
                Node newNode = new Node(nums[i], before, after);
                if(before != null){
                    before.after = newNode;
                }
                if(after != null){
                    after.before = newNode;
                }
                hm.put(nums[i], newNode);
            }
        }
        List<Node> startingPoint = new ArrayList<>();
        for(Map.Entry<Integer,Node> entry : hm.entrySet()){
            if(entry.getValue().before == null){
                startingPoint.add(entry.getValue());
            }
        }
        for(Node node: startingPoint){
            int length = 0;
            while(node != null){
                length++;
                node = node.after;
            }
            max = Math.max(max, length);
        }
    return max;
    }

    class Node{
        int val;
        Node before;
        Node after;
        public Node(int val, Node before, Node after){
            this.val = val;
            this.before = before;
            this.after = after;
        }
    }
}
