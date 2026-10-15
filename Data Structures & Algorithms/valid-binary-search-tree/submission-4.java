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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(root,null, null);
    }

    public boolean isValidBST(TreeNode root, Integer low, Integer high){
        if(root == null) return true;
        boolean left = false;
        boolean right = false;
        if(low == null){
            right = isValidBST(root.right, root.val, high);
        }
        else{
            right = root.val > low? isValidBST(root.right, root.val, high) : false;
        }
        if(!right) return false;
        if(high == null){
            left = isValidBST(root.left, low, root.val);
        }
        else
        {
            left = root.val < high? isValidBST(root.left, low, root.val) : false;
        }
        return left && right;

    }
}
