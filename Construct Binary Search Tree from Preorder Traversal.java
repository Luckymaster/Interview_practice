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
    TreeNode root;
    public TreeNode bstFromPreorder(int[] preorder) {
        for(int n : preorder){
            add(n);
        }
        return root;
    }
    void add(int n){
        root = add(root,n);
    }
    private TreeNode add(TreeNode root, int n){
        if(root == null){
            return new TreeNode(n);
        }
        if(root.val > n){
            root.left = add(root.left, n);
        }
        if(root.val < n){
             root.right = add(root.right, n);
        }
        return root;
    }
}
