/*
Given the root of a binary tree, return the sum of values of its deepest leaves.
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
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
	public int deepestLeavesSum(TreeNode root) {

		if (root == null)
			return 0;
		else {
			int lh = getHeight(root.left);
			int rh = getHeight(root.right);
            if(lh > rh ) return getSum(root.left, 1, lh);
			else if(rh > lh ) return getSum(root.right, 1, rh);
			return getSum(root.left, 1, lh) + getSum(root.right, 1, rh);

		}

	}

	int getHeight(TreeNode root) {
		return null == root ? 0 : Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
	}

	int getSum(TreeNode root, int l, int t) {

		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null && t == l) {
			return root.val;
		}
		return getSum(root.left, l + 1, t) + getSum(root.right, l + 1, t);
	}
}
