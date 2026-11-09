class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // 1. Add root if it is not a leaf node
        if (!isLeaf(root)) {
            result.add(root.val);
        }

        // 2. Add left boundary (excluding leaves)
        addLeftBoundary(root.left, result);

        // 3. Add all leaves from left to right
        addLeaves(root, result);

        // 4. Add right boundary in bottom-up order (excluding leaves)
        addRightBoundary(root.right, result);

        return result;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result) {
        TreeNode curr = node;
        while (curr != null) {
            if (!isLeaf(curr)) {
                result.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(TreeNode node, List<Integer> result) {
        TreeNode curr = node;
        List<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        // Add to result in reverse (bottom-up) order
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }
}
