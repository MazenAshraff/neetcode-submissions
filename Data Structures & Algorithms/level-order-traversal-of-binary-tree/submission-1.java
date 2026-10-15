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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ls = new ArrayList<>();
        if(root != null)
            q.add(root);
        while(!q.isEmpty()){
            Integer size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur != null){
                    level.add(cur.val);
                    if(cur.left != null)
                        q.add(cur.left);
                    if(cur.right != null)
                        q.add(cur.right);
                }
            }
            ls.add(level);
        }
        return ls;
    }
}
