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
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    Integer maxLevel = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root,0);
        for(int i = 0;i<maxLevel+1;i++){
            result.add(map.get(i));
        }
        return result;
    }
    public void levelOrder(TreeNode root, int level){
        if(root == null) return;
        maxLevel = Math.max(maxLevel,level);
        if(map.containsKey(level)){
            map.get(level).add(root.val);
        }
        else{
            map.put(level,new LinkedList<>());
            map.get(level).add(root.val);
        }
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}
