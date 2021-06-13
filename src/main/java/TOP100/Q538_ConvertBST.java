package TOP100;

/**
 * @author xushu
 * @create 6/6/21 2:01 PM
 * @desc
 */
public class Q538_ConvertBST {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        dfs(root);

        return root;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }

        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
