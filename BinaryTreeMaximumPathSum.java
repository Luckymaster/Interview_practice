/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path.
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
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
class Solution {
    int aux = 0;
    int c = 1;
    int maxSum = Integer.MIN_VALUE;
   	public int maxPathSum(TreeNode root) {

		aux = Integer.MIN_VALUE;
		maxSum = maxPathSum1(root);
		return Math.max(aux,maxSum);

	}

	int maxPathSum1(TreeNode root) {
		if (null == root) {
			return 0;
		}
		int lsum = Math.max(maxPathSum1(root.left), 0);
		int rsum = Math.max(maxPathSum1(root.right), 0);
		aux = Math.max(aux, lsum + rsum + root.val);
		return root.val + Math.max(lsum, rsum);

	}
}
