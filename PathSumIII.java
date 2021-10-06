/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
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
    int sum = 0;
	int	cnt = 0;
    List<Integer> ans;
   	public int pathSum(TreeNode root, int targetSum) {
		ans = new ArrayList<>();
		getSum3(root, targetSum);
		return cnt;

	}

	void getSum3(TreeNode root, int targetSum) {

		if (root == null) {
			return;
		}

		ans.add(root.val);
		getSum3(root.left, targetSum);
		getSum3(root.right, targetSum);

		int asum = 0;
		for (int i = ans.size() - 1; i >= 0; i--) {
			asum += ans.get(i);
			if (asum == targetSum) {
				cnt += 1;
			}
		}
		ans.remove(ans.size() - 1);

	}
}
