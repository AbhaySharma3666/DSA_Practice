class Solution {
    private static TreeNode build(int preStart, int preEnd, int inStart, int inEnd, int[] in, int[] preorder) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        
        int leftSubtreeSize = rootIndex - inStart;
        
        root.left = build(preStart + 1, preStart + leftSubtreeSize, inStart, rootIndex - 1, in, preorder);
        root.right = build(preStart + leftSubtreeSize + 1, preEnd, rootIndex + 1, inEnd, in, preorder);
        
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] in = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(in);
        int n = in.length;
        return build(0, n - 1, 0, n - 1, in, preorder);
    }
}