/**
 * Definition for a binary tree node.
 * 
 Input: root = [1,2,3,null,5]
 Output: ["1->2->5","1->3"]
 public class TreeNode {
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
    List<String> res;
    String path = "";
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        traverse(root,new StringBuilder());
        return res;
    }
    
    void traverse(TreeNode root, StringBuilder path){
        if(null == root) return;
        if(root.left == null && root.right == null){
            path.append(root.val);
            res.add(path.toString());
            path = new StringBuilder();
            return;
        }
        path.append("" + root.val +"->");
        traverse(root.left, new StringBuilder(path));
        traverse(root.right, new StringBuilder(path));
    }
}
