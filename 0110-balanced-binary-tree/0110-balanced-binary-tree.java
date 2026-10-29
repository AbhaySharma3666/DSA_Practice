class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {
        if (root == null) return 0;

        // Check left subtree height
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1; 

        // Check right subtree height
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1; 
        
        // If current node is unbalanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return actual height if balanced
        return 1 + Math.max(leftHeight, rightHeight);
    }
}