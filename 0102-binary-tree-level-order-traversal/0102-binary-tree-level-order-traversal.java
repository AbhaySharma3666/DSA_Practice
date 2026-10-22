import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode front = q.remove();
                currentLevel.add(front.val);

                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            ans.add(currentLevel);
        }
        
        return ans;
    }
}
