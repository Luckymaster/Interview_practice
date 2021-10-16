/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

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
class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return isBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
	private boolean isBST(TreeNode root, Long min, Long max) {
		if (root == null) return true;
        
        if(root.val *1L < min || root.val*1L > max) return false;
        
        return isBST(root.left, min, 1L*root.val-1) && isBST(root.right, 1L*root.val+1, max);
	}
}
