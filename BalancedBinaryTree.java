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
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return travers(root) == Integer.MAX_VALUE?false:true;
    }
    
    int travers(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lh = travers(root.left);
        int rh = travers(root.right);
        if(lh == Integer.MAX_VALUE || rh == Integer.MAX_VALUE || Math.abs(lh-rh) > 1) return Integer.MAX_VALUE;
        return Math.max(lh,rh)+1;
    }
}
