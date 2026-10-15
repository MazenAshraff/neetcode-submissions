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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inOrderIndex = new HashMap<>();
        for(int i = 0;i < inorder.length; i++){
            inOrderIndex.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1, 0, inOrderIndex);

    }

    public TreeNode buildTreeHelper(int [] preorder, int [] inorder, int startIn, int endIn,int startP, HashMap<Integer,Integer> inOrderIndex){
        if(startIn > endIn) return null;
        if(startIn == endIn) return new TreeNode(inorder[startIn]);
        TreeNode root = new TreeNode(preorder[startP]);
        int rootLocation = inOrderIndex.get(preorder[startP]);
        int leftLength = rootLocation - startIn + 1;
        root.left = buildTreeHelper(preorder, inorder,startIn, rootLocation - 1, startP + 1, inOrderIndex);
        root.right = buildTreeHelper(preorder, inorder,rootLocation + 1, endIn, startP + leftLength, inOrderIndex);
        return root;


    }
}
