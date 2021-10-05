/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        getSum(root,new ArrayList<>(),0,targetSum);
        return res;
        
    }
    
	void getSum(TreeNode root, List<Integer> num, int sum, int targetSum) {

		if (root == null) {
			return;
		}
		num.add(root.val);
		sum += root.val;
		if (root.left == null && root.right == null) {
			if (targetSum == sum) {
				res.add(num);
				num = new ArrayList<>();
			} else {
				num.remove(num.size() - 1);
			}
		} else {

			getSum(root.left, new ArrayList<>(num), sum, targetSum);
			getSum(root.right, new ArrayList<>(num), sum, targetSum);

		}

	}
}
