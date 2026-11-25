class Solution {
    private int size(TreeNode root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    private boolean isCBT(TreeNode root, int idx, int totalNodes) {
        if (root == null) return true;
        if (idx > totalNodes) return false;
        return isCBT(root.left, 2 * idx, totalNodes)
            && isCBT(root.right, 2 * idx + 1, totalNodes);
    }

    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = size(root);
        return isCBT(root, 1, totalNodes);
    }
}