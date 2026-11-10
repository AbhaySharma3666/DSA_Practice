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
    private int preIndex = 0;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Populate map for O(1) lookups of inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        // Current root value from preorder traversal
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Get index of root in inorder to split left and right subtrees
        int mid = inorderMap.get(rootVal);

        // Build left and right subtrees recursively
        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);

        return root;
    }
}