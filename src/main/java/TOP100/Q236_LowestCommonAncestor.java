package TOP100;

/**
 * @author xushu
 * @create 6/6/21 1:40 PM
 * @desc
 */
public class Q236_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null){
            return null;
        }

        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }
}
