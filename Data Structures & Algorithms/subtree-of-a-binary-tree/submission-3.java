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
        return isSubtree(root,subRoot, true);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot, boolean begin){
        if(root == null && subRoot == null) return true;
        if(root == null) return false;
        if(subRoot == null) return false;
        boolean answer = false;
        if(root.val == subRoot.val){
            answer |= (isSubtree(root.right, subRoot.right,false) && isSubtree(root.left, subRoot.left,false));
        }
        if(!answer && begin){
            answer |= isSubtree(root.right, subRoot, true) || isSubtree(root.left, subRoot, true);
        }
        return answer;
    }
}
