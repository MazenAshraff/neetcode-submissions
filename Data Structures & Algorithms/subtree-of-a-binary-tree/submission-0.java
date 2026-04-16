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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubTree(root, subRoot, true);

    }

    public boolean isSubTree(TreeNode root, TreeNode subRoot, boolean begin){
        if(subRoot == null && root == null){
            return true;
        }
        if(root == null || subRoot == null) return false;

        boolean checkCurrent = false;
        if(root.val == subRoot.val){
            checkCurrent = isSubTree(root.right, subRoot.right, false) && isSubTree(root.left, subRoot.left,false);
        }
        if(!begin) return checkCurrent;
        return checkCurrent || isSubTree(root.right, subRoot, true) || isSubTree(root.left, subRoot, true);
    


    }
}
