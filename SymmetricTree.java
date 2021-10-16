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
class SymmetricTree {
    List<Integer> lt,rt;
    public boolean isSymmetric(TreeNode root) {
        return areSame(root.left, root.right);
    }
    boolean areSame(TreeNode lt, TreeNode rt){
        if(lt == null && rt == null){
            return true;
        }
        if(lt== null || rt == null) return false;
        
        if(rt.val !=lt.val) return false;
        
        return areSame(lt.left,rt.right) && areSame(lt.right, rt.left);
    }

}
