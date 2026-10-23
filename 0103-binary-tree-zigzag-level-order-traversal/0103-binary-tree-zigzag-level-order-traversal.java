import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true; // Flag to track the traversal direction

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode front = q.remove();
                currentLevel.add(front.val);

                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            
            // If going right-to-left, reverse the elements of the current level
            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }
            
            ans.add(currentLevel);
            leftToRight = !leftToRight; // Toggle the direction for the next level
        }
        
        return ans;
    }
}