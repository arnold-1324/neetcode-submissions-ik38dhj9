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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }
    private void dfs(TreeNode node,StringBuilder sb)
    {
         if(node==null)
         {
            sb.append("N,");
            return;
         }
         sb.append(node.val).append(",");
         dfs(node.left,sb);
         dfs(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val=data.split(",");
        int[]idx=new int[1];
        return TreeBuilder(val,idx);
    }

    private TreeNode TreeBuilder(String[]val,int[]idx)
    {
        if(val[idx[0]].equals("N"))
        {
            idx[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(val[idx[0]]));
        idx[0]++;
        root.left=TreeBuilder(val,idx);
        root.right=TreeBuilder(val,idx);
        return root;
    }
}
