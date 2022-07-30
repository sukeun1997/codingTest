package leet;

import java.util.ArrayList;
import java.util.List;

public class Leet_199 {

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


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }


        findRightSide(root, list, 0);

        return list;
    }

    private void findRightSide(TreeNode root, List<Integer> list, int depth) {

        if (root == null) {
            return;
        }

        if (list.size() == depth) {
            list.add(root.val);
        }

        findRightSide(root.right, list, depth + 1);
        findRightSide(root.left, list, depth + 1);

    }

}
