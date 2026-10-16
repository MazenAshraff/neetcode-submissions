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
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        Integer []result = new Integer[]{root.val};
        helper(root, result);
        return result[0]; 
    }

    public int helper(TreeNode root, Integer[] result){
        if(root == null) return 0;
        if(root.right == null && root.left == null){
            result[0]= Math.max(result[0], root.val); 
            return root.val;
        }
        int left = root.val + helper(root.left, result);
        int right = root.val + helper(root.right,result);
        int returnedValue = Math.max(Math.max(left,right), root.val);
        result[0] = Math.max(Math.max(result[0], returnedValue), left+right - root.val);
        return returnedValue;
    }
}
