class Solution {

    private boolean exists(TreeNode root, TreeNode target) {
        if(root == null) return false;
        if(root == target) return true;
        return exists(root.left, target) || exists(root.right, target);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        boolean pLiesInLeft = exists(root.left, p);
        boolean qLiesInLeft = exists(root.left, q);

        if(pLiesInLeft && qLiesInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(!pLiesInLeft && !qLiesInLeft) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}