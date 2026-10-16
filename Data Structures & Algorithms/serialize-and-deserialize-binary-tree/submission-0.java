/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> tree = new ArrayList<Integer>();
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.add(root);
        while(!bfsQ.isEmpty()){
            int size = bfsQ.size();
            for(int i = 0; i < size;i++){
                TreeNode node = bfsQ.poll();
                if(node != null){
                    bfsQ.add(node.left);
                    bfsQ.add(node.right);
                    tree.add(node.val);
                }
                else{
                    tree.add(null);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tree.size(); i++){
            sb.append(tree.get(i));
            if(i!=tree.size() - 1){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] treeSplit = data.split(",");
        TreeNode root = parse(treeSplit[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i = 1; i< treeSplit.length; i+=2){
            TreeNode cur = q.poll();
            cur.left = parse(treeSplit[i]);
            cur.right = parse(treeSplit[i+1]);
            if(cur.left!= null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
        }
        return root;        
    }

    public TreeNode parse(String x){
        return x.equals("null")? null : new TreeNode(Integer.parseInt(x));
    }
}
