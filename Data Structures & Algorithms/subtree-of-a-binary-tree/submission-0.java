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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(subRoot==null) return true;
       if(root==null) return false;
       if(sameTree(root,subRoot)) return true;
       return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    private boolean sameTree(TreeNode parent,TreeNode child)
    {
        if(parent==null && child==null) return true;
        if(parent==null || child==null || parent.val!=child.val) return false;
        return sameTree(parent.left,child.left) && sameTree(parent.right,child.right);
    }
}
