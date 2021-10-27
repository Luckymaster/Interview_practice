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
    Map<Integer, Integer> depth = new HashMap<>();
    int max = 0;
    public List<Double> averageOfLevels(TreeNode root) {
        orderTravershal(root, 1);
        List<Double> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> kv :depth.entrySet() ){
            Double res = kv.getValue() * 100000.0;
            ans.add(res/(kv.getKey() *100000.0));
        }
        return ans;
    }
    
    void orderTravershal(TreeNode root, int d){
        if(null!= root){
            
            if(max < d){
                depth.put(d, root.val);
                max = d;
            }else{
                depth.put(d, depth.get(d) + root.val);
            }
            orderTravershal(root.left,  d+1);
            orderTravershal(root.right, d+1);
        }
    }
}
