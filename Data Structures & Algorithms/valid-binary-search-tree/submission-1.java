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
        return isValidBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int low, int high){
        if(root == null) return true;
        if(!(root.val > low && root.val < high)) return false;
        if(root.left !=null && root.right!=null){
            if(root.val > root.left.val && root.val < root.right.val){
                return isValidBST(root.left, low, Math.min(high, root.val)) &&
                isValidBST(root.right, Math.max(low, root.val), high);
            }
            else{
                return false;
            }
        }
        else{
            if(root.left!=null){
                if(root.left.val < root.val)
                    return isValidBST(root.left,low, Math.min(high, root.val));
                else 
                    return false;
            }
            else{
                if(root.right != null){
                    if(root.right.val > root.val){
                        return isValidBST(root.right,Math.max(low, root.val), high);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return true;
                }
            }
        }
    }
}
