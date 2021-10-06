/*
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Input: root = [1,3,2,5,null,null,9,6,null,null,7]
Output: 8
Explanation: The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
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
	int widthOfBinaryTree(TreeNode root) {

		Queue<java.util.AbstractMap.SimpleEntry<TreeNode,Integer> > queue = new LinkedList<>();

		queue.add(new java.util.AbstractMap.SimpleEntry<>(root, 0));
		int ans = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			int left = queue.peek().getValue();
			int right = left;

			for (int i = 0; i < size; i++) {
				java.util.AbstractMap.SimpleEntry<TreeNode, Integer> aux = queue.poll();

				right = aux.getValue();

				TreeNode node = aux.getKey();

				if (node.left != null) {
					queue.add(new java.util.AbstractMap.SimpleEntry<>(node.left, right * 2));
				}
				if (node.right != null) {
					queue.add(new java.util.AbstractMap.SimpleEntry<>(node.right, right * 2 + 1));
				}

			}
			ans = Math.max(right - left + 1, ans);

		}
		return ans;
	}
}
