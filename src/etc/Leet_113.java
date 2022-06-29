package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Leet_113 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root,targetSum);

        return answer;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }


        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            answer.add(new ArrayList<>(list));
        } else {
            dfs(root.left, targetSum - root.val);
            dfs(root.right, targetSum - root.val);
        }
        list.remove(list.size() - 1);

    }

}
