/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

	List<Integer>[] adj;
	List<Integer> ans = new ArrayList<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

		adj = new ArrayList[501];
        for(int i=0;i<501;i++){
            adj[i] = new ArrayList<>();
        }
		traverse(root);
		boolean[] isVisited = new boolean[501];
		dfs(target.val, isVisited, 0, k);
		return ans;

	}

	int getTotalNodes(TreeNode root, int cnt) {

		return root == null ? 0 : getTotalNodes(root.left, cnt + 1) + getTotalNodes(root.right, cnt + 1) + 1;
	}

	void dfs(int v, boolean[] isVisited, int cnt, int k) {

		isVisited[v] = true;
		if (cnt == k) {
			ans.add(v);
		}
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {

			int i = it.next();
			if(!isVisited[i])
			dfs(i, isVisited, cnt + 1, k);

		}

	}

	void traverse(TreeNode root) {

		if (null != root) {

			if (root.right != null) {
				adj[root.val].add(root.right.val);
				adj[root.right.val].add(root.val);
				traverse(root.right);
			}
			if (root.left != null) {
				adj[root.val].add(root.left.val);
				adj[root.left.val].add(root.val);
				traverse(root.left);
			}

		}
	}
}
