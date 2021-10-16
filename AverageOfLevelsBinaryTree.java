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
class AverageOfLevelsBinaryTree {
    Map<Integer, List<Integer>> depth = new HashMap<>();
    int max = 0;
    public List<Double> averageOfLevels(TreeNode root) {
        orderTravershal(root, 1);
        List<Double> ans = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> kv :depth.entrySet() ){
            int len = kv.getValue().size();
            Double sum = 0.0;
            for(Integer a:kv.getValue()){
                sum += a *1.0;
                System.out.print(a+" ");
            }
            Double res = sum * 100000;
            ans.add(res/(len *100000));
        }
        return ans;
    }
    
    void orderTravershal(TreeNode root, int d){
        if(null!= root){
            
            if(max < d){
                List<Integer> aux = new ArrayList<>();
                aux.add(root.val);
                depth.put(d, aux);
                max = d;
            }else depth.get(d).add(root.val);
            orderTravershal(root.left,  d+1);
            orderTravershal(root.right, d+1);
        }
    }
}
