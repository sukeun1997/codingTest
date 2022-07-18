package leet;

public class Leet_98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isValidBST(TreeNode root) {


        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, TreeNode min , TreeNode max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val < min.val) || (max != null && max.val < root.val)) {
            return false;
        }

        return dfs(root.left, min, root) && dfs(root.right, root, max);
    }


}
