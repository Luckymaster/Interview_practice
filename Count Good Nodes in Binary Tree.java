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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        getGoodNodes(root,root.val, root.val);
        return cnt;
    }
    
    void getGoodNodes(TreeNode root, int maxval, int val){
        
        if(root == null){
            return;
        }
        if(maxval <= val){
            cnt+=1;
        }
        if(root.left!= null)
            getGoodNodes(root.left ,  Math.max(maxval,root.left.val ),root.left.val );
        if(root.right!= null)
            getGoodNodes(root.right , Math.max(maxval,root.right.val ),root.right.val );
    }
}
