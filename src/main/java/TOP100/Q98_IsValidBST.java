package TOP100;


/**
 * @author xushu
 * @create 5/25/21 4:29 PM
 * @desc
 */
public class Q98_IsValidBST {

    private TreeNode compare;

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        boolean left = isValidBST(root.left);

        if(compare != null && compare.val >= root.val){
            return false;
        }

        compare = root;

        boolean right = isValidBST(root.right);

        return left && right;
    }

}
