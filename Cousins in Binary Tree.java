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
    int [] parent;
    int [] depth;
    int max = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        parent = new int[101];
        depth =  new int[101];
        buildParent(root,1);
        return (depth[x] == depth[y] && parent[x]!=parent[y]) ? true:false;
    }
    void buildParent(TreeNode root, int d){
        if(root != null){
            
            depth[root.val] = d;
            if(max < d){
                max = d;
            }
            if(root.left!= null){
                parent[root.left.val] = root.val;
            }
            buildParent(root.left,d+1);
            if(root.right!= null){
                parent[root.right.val] = root.val;
            }
            buildParent(root.right,d+1);
        }
    }
}
