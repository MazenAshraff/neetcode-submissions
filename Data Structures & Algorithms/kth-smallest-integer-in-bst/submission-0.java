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
    private Integer result = null;
    private Integer currentLocation = 0; 
    public int kthSmallest(TreeNode root, int k) {
        Integer result = null;
        inOrderTraversal(root, k);
        result = this.result;
        this.result = 0;
        this.currentLocation = 0;
        return result;
    }

    private void inOrderTraversal(TreeNode root, int k){
        if(result != null || root == null) return;
        inOrderTraversal(root.left, k);
        currentLocation++;
        if(currentLocation == k){
            result = root.val;
        }
        inOrderTraversal(root.right,k);
        
    }
}
