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
    Map<Integer, Boolean> nodes = new HashMap<>();
    public int maxAncestorDiff(TreeNode root) {
        parent = new int[100001];
        Arrays.fill(parent, -1);
        buildParent(root);
        int ans = -1;
        for(Map.Entry<Integer,Boolean> ll : nodes.entrySet()){
            int aux = ll.getKey();
            while(aux!=-1){
                int d = Math.abs(aux - ll.getKey());
                if(nodes.get(d)!=null){
                    ans = Math.max(ans, d);
                }
                aux = parent[aux];
            }
        }
        return ans;
    }
    void buildParent(TreeNode root){
        if(root!= null){
            nodes.put(root.val, true);
            if(root.left!= null){
                parent[root.left.val] = root.val;
            }
            buildParent(root.left);
            if(root.right!= null){
                parent[root.right.val] = root.val;
            }
            buildParent(root.right);
        }
    }
}
