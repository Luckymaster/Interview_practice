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
    public int countNodes(TreeNode root) {
        return getCompleteNodes(root);
    }
    
    int getLeftHeight(TreeNode root){
        return root == null?0:getLeftHeight(root.left) +1;
    }
    int getRightHeight(TreeNode root){
        return root == null?0:getRightHeight(root.right) +1;
    }
    
    int getCompleteNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        //System.out.println("lh = " + lh +" rh = " + rh);
        if(lh == rh) return (1<<lh) - 1;
        return getCompleteNodes(root.left) + getCompleteNodes(root.right) + 1;
    }
}
