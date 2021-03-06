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
    int ans = 0;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }
    
    void inOrder(TreeNode root, int k){
        if(root!= null){
            
            inOrder(root.left, k);
            cnt+=1;
            if(cnt == k){
                ans = root.val;
                return;
            }
            inOrder(root.right,k);
        }
    }
}
