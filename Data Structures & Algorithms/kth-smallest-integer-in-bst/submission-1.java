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

    public int kthSmallest(TreeNode root, int k) {
        int [] result = new int[]{0};
        int [] currentLocation =new int[]{0}; 
        inOrderTraversal(root, k, result, currentLocation);

        return result[0];
    }

    private void inOrderTraversal(TreeNode root, int k,int [] result,int [] currentLocation){
        if(currentLocation[0]>=k || root == null) return;
        inOrderTraversal(root.left, k, result, currentLocation);
        currentLocation[0]++;
        if(currentLocation[0] == k){
            result[0] = root.val;
        }
        inOrderTraversal(root.right,k,result, currentLocation);
        
    }
}
