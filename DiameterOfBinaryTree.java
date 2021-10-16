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
class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return diaMeter(root);
    }
    int diaMeter(TreeNode root){
        if(root == null) return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        int dm = diaMeter(root.left);
        int dr = diaMeter(root.right);
        
        return Math.max(l+r, Math.max(dm,dr));
        
    }
    
    int getDepth(TreeNode root){
        return root == null ? 0: 1 + Math.max(getDepth(root.left),getDepth(root.right));
    }
}
